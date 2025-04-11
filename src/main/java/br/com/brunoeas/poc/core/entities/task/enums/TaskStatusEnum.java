package br.com.brunoeas.poc.core.entities.task.enums;

import br.com.brunoeas.poc.core.entities.common.enums.PersistentEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public enum TaskStatusEnum implements PersistentEnum<Integer> {
    ACTIVE(1, "Active");

    private final Integer code;
    private final String description;

}
