package br.com.brunoeas.poc.adapters.repositories.task;

import br.com.brunoeas.poc.core.entities.task.Task;
import br.com.brunoeas.poc.core.ports.task.TaskRepository;
import io.quarkus.arc.DefaultBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.ext.Provider;

@Provider
@DefaultBean
public class TaskRepositoryImpl implements TaskRepository {

    @Inject
    JpaTaskRepository repository;

    @Override
    public void persist(Task task) {
        this.repository.persist(task);
    }

}
