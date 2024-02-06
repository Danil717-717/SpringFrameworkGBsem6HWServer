package ru.springgb.sem6HW.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.springgb.sem6HW.Executor;


import java.util.List;

public interface ExecutorRepository extends JpaRepository<Executor, Long> {

}
