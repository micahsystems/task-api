package com.example.taskapi.repository;

import com.example.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// Note: this is an interface, not a class. We never write an implementation -
// Spring Data JPA generates one at startup using a dynamic proxy, based on
// the methods we declare (or inherit from JpaRepository).
//
// JpaRepository<Task, Long> gives us save(), findById(), findAll(), deleteById(),
// etc. for free, where Task is the entity type and Long is the type of its @Id field.
public interface TaskRepository extends JpaRepository<Task, Long> {
}
