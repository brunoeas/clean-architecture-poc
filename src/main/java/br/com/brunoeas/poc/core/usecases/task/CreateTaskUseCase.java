package br.com.brunoeas.poc.core.usecases.task;

import br.com.brunoeas.poc.core.entities.common.enums.IndicatorYesNoEnum;
import br.com.brunoeas.poc.core.entities.task.Task;
import br.com.brunoeas.poc.core.entities.task.enums.TaskStatusEnum;
import br.com.brunoeas.poc.core.ports.task.TaskRepository;
import br.com.brunoeas.poc.core.usecases.common.validations.BeanValidator;
import br.com.brunoeas.poc.core.usecases.task.requests.CreateTaskRequest;
import br.com.brunoeas.poc.core.usecases.task.responses.TaskIdResponse;
import br.com.brunoeas.poc.infrastructure.exceptions.CustomException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.stream.Stream;

@ApplicationScoped
public class CreateTaskUseCase {

    @Inject
    TaskRepository taskRepository;

    @Transactional(rollbackOn = Exception.class)
    public TaskIdResponse execute(final CreateTaskRequest request) throws CustomException {
        BeanValidator.validate(request);

        final Task task = new Task();
        task.setDescription(request.getDescription());
        task.setName(request.getName());
        task.setStatus(Stream.of(TaskStatusEnum.values())
                .filter(item -> item.getCode().equals(request.getStatus()))
                .findFirst()
                .orElseThrow());
        task.setResponsibleUser(request.getResponsibleUser());
        task.setIndicatorPublic(Stream.of(IndicatorYesNoEnum.values())
                .filter(item -> item.getCode().equals(request.getIndicatorPublic()))
                .findFirst()
                .orElseThrow());
        this.taskRepository.persist(task);

        return new TaskIdResponse(task.getId());
    }

}
