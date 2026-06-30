package com.example.taskapi.exception;

// A plain custom exception. We'll throw this from the service layer when
// someone asks for a task ID that doesn't exist, and catch it globally
// to turn it into a clean 404 response instead of a raw stack trace.
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }
}
