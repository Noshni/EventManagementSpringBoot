package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
