package com.example.todo.services;

import com.example.todo.models.Task;
import com.example.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id,Task task) {
        if (taskRepository.findById(id).isPresent()){
            taskRepository.findById(id).map(task1 -> {

                task1.setContent(task.getContent());
                task1.setStatus(task.getStatus());
                return taskRepository.save(task1);
            });
            task.setId(id);
            return task;
        }

        return null;

    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateStatus(Long id, String status) {
        return null;
    }

    @Override
    public Optional<Task> getById(Long id) {
        if (taskRepository.findById(id).isEmpty()){

        }
        return taskRepository.findById(id);
    }
}
