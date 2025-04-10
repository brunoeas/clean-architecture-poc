package br.com.brunoeas.poc.common.exception;

import jakarta.annotation.Priority;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(1)
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {

    /**
     * Map an exception to a {@link Response}. Returning {@code null} results in a
     * {@link Response.Status#NO_CONTENT} response. Throwing a runtime exception results in a
     * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
     *
     * @param exception the exception to map to a response.
     * @return a response mapped from the supplied exception.
     */
    @Override
    public Response toResponse(final CustomException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorListDTO.builder()
                        .errors(exception.getErrors().stream().toList())
                        .build())
                .build();
    }

}
