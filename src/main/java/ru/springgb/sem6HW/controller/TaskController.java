package ru.springgb.sem6HW.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.springgb.sem6HW.Executor;
import ru.springgb.sem6HW.Task;
import ru.springgb.sem6HW.repository.ExecutorRepository;
import ru.springgb.sem6HW.repository.TaskRepository;
import ru.springgb.sem6HW.service.ExecutorService;
import ru.springgb.sem6HW.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    private final ExecutorService executorService;


    @GetMapping("/tasks")
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


//    @PutMapping("/tasks/{id}/executors")
//    public Task createTask(@PathVariable Long id,@RequestBody Executor executor) {
//        Executor executor1 = taskService.save(executor);
//        List<Executor> listEx = new ArrayList<>();
//        listEx.add(executor1);
//
//        Task task1 = taskService.getTaskById(id);
//        task1.addexecutor(executor1);
//        task1.setExecutors(listEx);
//        return task1;
//
//    }

    @PutMapping("/tasks/{id}/executors/{executorsid}")
    public Task addExecInTask(@PathVariable Long id,@PathVariable Long executorsid) {
        return taskService.assignExecutor(id,executorsid);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }


    @PostMapping("/executors")
    public Executor createExecutor(@RequestBody Executor executor) {
        return executorService.save(executor);
    }


    @GetMapping("/executors")
    public List<Executor> getAllExecutor() {
        return executorService.findAll();
    }


    @GetMapping("/executors/{id}")
    public Executor getExecutorById(@PathVariable Long id) {
        return executorService.findById(id);
    }


    @PutMapping("/executors/{id}")
    public Executor updateExecutor(@PathVariable Long id, @RequestBody Executor executor) {
        return executorService.updateExecutor(id, executor);
    }

    @PutMapping("/executors/{id}/tasks/{tasksId}")
    public Executor addTaskInExecutor(@PathVariable Long id,@PathVariable Long tasksId) {
        return taskService.assignTask(id,tasksId);
    }


    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }


    @DeleteMapping("/executors/{id}")
    public void deleteExecutor(@PathVariable Long id) {
        executorService.deleteById(id);
    }


    @GetMapping("/executor/{id}/tasks")
    public List<Task> getTasksPoExecutors(@PathVariable Long id) {
        return taskService.getTasksExecutor(id);
    }

    @GetMapping("/tasks/{id}/executor")
    public List<Executor> getExecutorsByTask(@PathVariable Long id) {
        return taskService.getExecutorsTask(id);
    }


}

