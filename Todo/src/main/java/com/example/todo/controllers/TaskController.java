package com.example.todo.controllers;

import com.example.todo.models.ResponseObject;
import com.example.todo.models.Task;
import org.springframework.http.ResponseEntity;

public interface TaskController {
    public ResponseEntity<ResponseObject> getAllTasks();

    public ResponseEntity<ResponseObject> createTask(Task task);

    public ResponseEntity<ResponseObject> getById(Long id);

    public ResponseEntity<ResponseObject> deleteById(Long id);

    public ResponseEntity<ResponseObject> updateTask(Long id, Task task);

}
