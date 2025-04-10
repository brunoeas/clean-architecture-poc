package br.com.brunoeas.poc.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public enum IndicatorYesNoEnum implements PersistentEnum<String> {
    YES("Y", "Yes"),
    NO("N", "No");

    private final String code;
    private final String description;

}
