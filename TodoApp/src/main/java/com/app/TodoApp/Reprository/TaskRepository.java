package com.app.TodoApp.Reprository;

import com.app.TodoApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
