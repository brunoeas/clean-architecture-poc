package br.com.brunoeas.poc.infrastructure.exceptions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum ErrorMessageEnum {
    UNKNOWN_ERROR("999", "An unexpected error occurred."),
    REQUIRED_FIELD("001", "Required field has no value. Complete the field with a valid value."),
    REQUIRED_RESPONSIBLE_USER("002", "User responsible for the action was not informed.");

    private final String code;
    private final String message;

}
