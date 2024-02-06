package ru.springgb.sem6HW;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Executor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);

    }

    public void removeTask(long taskId) {
        Task task = this.tasks.stream().filter(t -> t.getId() == taskId)
                .findFirst().orElse(null);
        if (task != null) {
            this.tasks.remove(task);

        }
    }

}
