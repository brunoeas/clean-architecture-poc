package br.com.brunoeas.poc.common.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

import static java.util.Objects.isNull;

@EqualsAndHashCode(callSuper = true)
@Getter
public class CustomException extends RuntimeException {

    private final Collection<ErrorDTO> errors;

    public CustomException(final Collection<ErrorDTO> errors) {
        super();
        Objects.requireNonNull(errors);
        if (errors.isEmpty()) {
            throw new IllegalArgumentException("Field \"errors\" is empty.");
        }
        this.errors = errors;
    }

    public CustomException(final ErrorMessageEnum errorMessageEnum, final Map<String, String> monitoredVariables) {
        super();
        Objects.requireNonNull(errorMessageEnum);
        final Map<String, String> monitoredVariablesNewInstance = isNull(monitoredVariables) ? new HashMap<>() : new HashMap<>(monitoredVariables);
        this.errors = Collections.singletonList(
                ErrorDTO.builder()
                        .code(errorMessageEnum.getCode())
                        .message(errorMessageEnum.getMessage())
                        .monitoredVariables(monitoredVariablesNewInstance)
                        .build()
        );
    }

    public CustomException(final ErrorMessageEnum errorMessageEnum) {
        this(errorMessageEnum, null);
    }

}
