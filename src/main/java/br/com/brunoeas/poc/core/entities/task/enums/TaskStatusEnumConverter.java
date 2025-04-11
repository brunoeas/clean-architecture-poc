package br.com.brunoeas.poc.core.entities.task.enums;

import br.com.brunoeas.poc.core.entities.common.enums.AbstractEnumConverter;
import jakarta.persistence.Converter;

@Converter
public class TaskStatusEnumConverter extends AbstractEnumConverter<TaskStatusEnum, Integer> {
    public TaskStatusEnumConverter() {
        super(TaskStatusEnum.class);
    }
}
