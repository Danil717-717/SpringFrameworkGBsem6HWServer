package ru.springgb.sem6HW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springgb.sem6HW.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
