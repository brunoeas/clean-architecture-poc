package br.com.brunoeas.poc.adapters.repositories.task;

import br.com.brunoeas.poc.core.entities.task.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JpaTaskRepository implements PanacheRepositoryBase<Task, Long> {
}
