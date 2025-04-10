package br.com.brunoeas.poc.common.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ErrorListDTO implements Serializable {

    private List<ErrorDTO> errors;

}
