package br.com.brunoeas.poc.core.usecases.task;

import br.com.brunoeas.poc.core.entities.common.enums.IndicatorYesNoEnum;
import br.com.brunoeas.poc.core.entities.task.Task;
import br.com.brunoeas.poc.core.entities.task.enums.TaskStatusEnum;
import br.com.brunoeas.poc.core.ports.task.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreateTaskUseCase {

    @Inject
    TaskRepository taskRepository;

    @Transactional(rollbackOn = Exception.class)
    public void execute() {
        final Task task = new Task();
        task.setDescription("aa");
        task.setName("nome");
        task.setStatus(TaskStatusEnum.ACTIVE);
        task.setResponsibleUser("asdasd");
        task.setIndicatorPublic(IndicatorYesNoEnum.NO);
        this.taskRepository.persist(task);
    }

}
