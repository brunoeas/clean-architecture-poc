package br.com.brunoeas.poc.infrastructure.exceptions;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ErrorDTO implements Serializable {

    private String code;

    private String message;

    @Builder.Default
    private Map<String, String> monitoredVariables = new HashMap<>();

}
