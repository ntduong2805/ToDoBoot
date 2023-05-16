package com.example.todo.services;

import com.example.todo.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public Task createTask(Task task);
    public List<Task> getAll();
    public Task updateTask(Long id,Task task);
    void deleteTask(Long id);
    public Task updateStatus(Long id, String status);
    public Optional<Task> getById(Long id);
}
