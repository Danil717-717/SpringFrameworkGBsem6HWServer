package ru.springgb.sem6HW.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.springgb.sem6HW.Executor;
import ru.springgb.sem6HW.Task;

import java.util.List;

@Service
public interface TaskService {

    Task createTask(Task task);

    Task save(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);
    List<Task> getTaskStatus(String status);

    Task updateTask(Long id, Task task);

    Task apdateTask(Task task);
    void deleteById(Long id);

    Task assignExecutor(Long id, Long executorId);
    Executor assignTask(Long id, Long taskId);
    List<Task> getTasksExecutor(Long id);

    List<Executor> getExecutorsTask(Long id);

    Executor save(Executor executor);


    Page<Task> findPaginated(int pageNo, int pageSize);


    Page<Task> findPaginated(Pageable pageable);
}
