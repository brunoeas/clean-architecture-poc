package br.com.brunoeas.poc.core.usecases.task.requests;

import br.com.brunoeas.poc.core.entities.common.enums.IndicatorYesNoEnum;
import br.com.brunoeas.poc.core.entities.task.enums.TaskStatusEnum;
import br.com.brunoeas.poc.core.usecases.common.validations.ValidPersistentEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CreateTaskRequest implements Serializable {

    @NotBlank(message = "REQUIRED_FIELD")
    @Size(message = "INVALID_NUMBER_OF_CHARACTERS", max = 100, min = 2)
    private String name;

    @NotBlank(message = "REQUIRED_FIELD")
    @Size(message = "INVALID_NUMBER_OF_CHARACTERS", max = 300, min = 2)
    private String description;

    @ValidPersistentEnum(message = "INVALID_FORMAT", enumClass = TaskStatusEnum.class)
    @NotNull(message = "REQUIRED_FIELD")
    private Integer status;

    @ValidPersistentEnum(message = "INVALID_FORMAT", enumClass = IndicatorYesNoEnum.class)
    @NotBlank(message = "REQUIRED_FIELD")
    private String indicatorPublic;

    @NotBlank(message = "REQUIRED_RESPONSIBLE_USER")
    @Size(message = "INVALID_NUMBER_OF_CHARACTERS", max = 40, min = 2)
    private String responsibleUser;

}
