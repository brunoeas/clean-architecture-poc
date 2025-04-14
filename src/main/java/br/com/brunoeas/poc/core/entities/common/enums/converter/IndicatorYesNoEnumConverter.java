package br.com.brunoeas.poc.core.entities.common.enums.converter;

import br.com.brunoeas.poc.core.entities.common.enums.IndicatorYesNoEnum;
import jakarta.persistence.Converter;

@Converter
public class IndicatorYesNoEnumConverter extends AbstractEnumConverter<IndicatorYesNoEnum, String> {
    public IndicatorYesNoEnumConverter() {
        super(IndicatorYesNoEnum.class);
    }
}
