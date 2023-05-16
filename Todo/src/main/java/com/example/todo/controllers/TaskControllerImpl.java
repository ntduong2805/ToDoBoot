package com.example.todo.controllers;

import com.example.todo.models.ResponseObject;
import com.example.todo.models.Task;
import com.example.todo.repositories.TaskRepository;
import com.example.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class TaskControllerImpl implements TaskController{
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskService taskService;

    @Override
    @GetMapping()
    public ResponseEntity<ResponseObject> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","",taskService.getAll())
        );
    }

    @Override
    @PostMapping()
    public ResponseEntity<ResponseObject> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","",taskService.createTask(task))
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        if(taskService.getById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FAILED","","NA")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","",taskService.getById(id))
        );
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteById(@PathVariable Long id) {
        if(taskService.getById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("FAILED","","NA")
            );
        }
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","","na"));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateTask(@PathVariable Long id,@RequestBody Task task) {
//        taskService.updateTask(id,task);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","",taskService.updateTask(id,task)));

    }


}
