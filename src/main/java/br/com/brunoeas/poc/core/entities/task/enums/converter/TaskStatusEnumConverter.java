package br.com.brunoeas.poc.core.entities.task.enums.converter;

import br.com.brunoeas.poc.core.entities.common.enums.converter.AbstractEnumConverter;
import br.com.brunoeas.poc.core.entities.task.enums.TaskStatusEnum;
import jakarta.persistence.Converter;

@Converter
public class TaskStatusEnumConverter extends AbstractEnumConverter<TaskStatusEnum, Integer> {
    public TaskStatusEnumConverter() {
        super(TaskStatusEnum.class);
    }
}
