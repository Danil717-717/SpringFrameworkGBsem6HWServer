package ru.springgb.sem6HW.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.springgb.sem6HW.Executor;
import ru.springgb.sem6HW.Task;
import ru.springgb.sem6HW.repository.ExecutorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorRepository repository;

    @Override
    public List<Executor> findAll() {
        return repository.findAll();
    }

    @Override
    public Executor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public Executor save(Executor executor) {
        return repository.save(executor);
    }

    public Executor getExecutor(Long id) {
        return findAll().stream().filter(executor  -> executor.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Executor updateExecutor(Long id, Executor executor) {
        Executor executorStaraya = getExecutor(id);
        if (executorStaraya != null) {
            executorStaraya.setName(executor.getName());
        }
        return executorStaraya;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public Executor assignTask(Long id, Long taskId) {
//        Executor existingExecutor = findById(id);
//        Task task = taskService.getTaskById(taskId);
//        List<Task> listTask = null;
//        listTask.add(task);
//        existingExecutor.setTasks(listTask);
//        return existingExecutor;
//    }
}