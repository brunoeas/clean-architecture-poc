package br.com.brunoeas.poc.adapters.controllers;

import br.com.brunoeas.poc.core.usecases.task.CreateTaskUseCase;
import br.com.brunoeas.poc.core.usecases.task.requests.CreateTaskRequest;
import br.com.brunoeas.poc.infrastructure.exceptions.CustomException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    CreateTaskUseCase createTaskUseCase;

    @POST
    public Response createTask(final CreateTaskRequest request) throws CustomException {
        return Response.status(Response.Status.CREATED)
                .entity(this.createTaskUseCase.execute(request))
                .build();
    }

}
