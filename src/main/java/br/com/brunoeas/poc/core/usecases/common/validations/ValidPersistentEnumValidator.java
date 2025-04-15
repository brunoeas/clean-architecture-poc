package br.com.brunoeas.poc.core.usecases.common.validations;

import br.com.brunoeas.poc.core.entities.common.enums.PersistentEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.stream.Stream;

public class ValidPersistentEnumValidator implements ConstraintValidator<ValidPersistentEnum, Object> {

    private Class<? extends PersistentEnum<?>> enumClass;

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(final ValidPersistentEnum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.enumClass = constraintAnnotation.enumClass();
        Objects.requireNonNull(this.enumClass);
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (Objects.isNull(value)) return true;

        return Stream.of(this.enumClass.getEnumConstants())
                .anyMatch(item -> Objects.equals(item.getCode(), value));
    }

}
