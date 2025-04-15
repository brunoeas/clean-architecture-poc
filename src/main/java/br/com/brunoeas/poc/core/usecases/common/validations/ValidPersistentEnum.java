package br.com.brunoeas.poc.core.usecases.common.validations;

import br.com.brunoeas.poc.core.entities.common.enums.PersistentEnum;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = { ValidPersistentEnumValidator.class })
@Target({ FIELD, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ValidPersistentEnum {

    String message();

    Class<? extends PersistentEnum<?>> enumClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
