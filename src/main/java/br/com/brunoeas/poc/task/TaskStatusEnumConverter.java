package br.com.brunoeas.poc.task;

import br.com.brunoeas.poc.common.enums.AbstractEnumConverter;
import jakarta.persistence.Converter;

@Converter
public class TaskStatusEnumConverter extends AbstractEnumConverter<TaskStatusEnum, Integer> {
    public TaskStatusEnumConverter() {
        super(TaskStatusEnum.class);
    }
}
