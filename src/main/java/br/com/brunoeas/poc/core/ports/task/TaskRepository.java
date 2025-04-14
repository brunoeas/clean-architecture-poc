package br.com.brunoeas.poc.core.ports.task;

import br.com.brunoeas.poc.core.entities.task.Task;

public interface TaskRepository {

    void persist(final Task task);

}
