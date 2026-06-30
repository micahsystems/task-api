package com.example.taskapi.service;

import com.example.taskapi.exception.TaskNotFoundException;
import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service marks this as a Spring-managed bean in the "service" layer.
// Functionally identical to @Component, but the name documents intent:
// this is where business logic lives, separate from HTTP concerns (controller)
// and database concerns (repository).
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor injection: Spring sees this constructor, notices it needs a
    // TaskRepository, finds the bean Spring Data JPA generated for that interface,
    // and passes it in automatically when creating TaskService. No "new" keyword
    // anywhere - this is what "dependency injection" means in practice.
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id); // reuses the not-found check above
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        Task existingTask = getTaskById(id); // throws 404 if it doesn't exist
        taskRepository.delete(existingTask);
    }
}
