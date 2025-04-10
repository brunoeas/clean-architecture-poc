package br.com.brunoeas.poc.common.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.*;

public final class BeanValidator {

    public static <T> Set<ConstraintViolation<T>> validation(final T bean) {
        Objects.requireNonNull(bean);
        try (final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            final Validator validator = validatorFactory.getValidator();
            return validator.validate(bean);
        }
    }

    public static <T> void validate(final T bean) throws CustomException {
        final Set<ConstraintViolation<T>> constraintViolations = validation(bean);

        final List<ErrorDTO> errors = constraintViolations.stream()
                .map(BeanValidator::mapConstraintViolationToChatErrorDTO)
                .toList();

        if (!errors.isEmpty()) {
            throw new CustomException(errors);
        }
    }

    private static <T> ErrorDTO mapConstraintViolationToChatErrorDTO(final ConstraintViolation<T> constraint) {
        Objects.requireNonNull(constraint.getMessage());
        final String[] params = constraint.getMessage().split(";");
        if (params.length < 1) {
            throw new IllegalArgumentException("Incorrect use of validation annotations.");
        }

        final ErrorMessageEnum errorMessageEnum;
        try {
            errorMessageEnum = ErrorMessageEnum.valueOf(params[0]);
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("Incorrect use of validation annotations.", e);
        }

        final Map<String, String> monitoredVariables = new HashMap<>(buildDefaultMonitoredVariables(constraint));
        return ErrorDTO.builder()
                .code(errorMessageEnum.getCode())
                .message(errorMessageEnum.getMessage())
                .monitoredVariables(monitoredVariables)
                .build();
    }

    private static <T> Map<String, String> buildDefaultMonitoredVariables(final ConstraintViolation<T> constraint) {
        return Map.of(
                MonitoredVariableKeys.FIELD, constraint.getPropertyPath().toString(),
                MonitoredVariableKeys.VALUE, String.valueOf(constraint.getInvalidValue())
        );
    }

}
