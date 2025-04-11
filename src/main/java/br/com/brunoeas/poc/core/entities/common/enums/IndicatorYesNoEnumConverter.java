package br.com.brunoeas.poc.core.entities.common.enums;

import jakarta.persistence.Converter;

@Converter
public class IndicatorYesNoEnumConverter extends AbstractEnumConverter<IndicatorYesNoEnum, String> {
    public IndicatorYesNoEnumConverter() {
        super(IndicatorYesNoEnum.class);
    }
}
