package com.mondi.intgress.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TaskModel")
public class TaskModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "taskId")
    private TaskListModel taskList;

    public TaskModel() {
    }

    public TaskModel(String description, LocalDateTime dueDate, TaskListModel taskList) {
        this.description = description;
        this.dueDate = dueDate;
        this.taskList = taskList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskListModel getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskListModel taskList) {
        this.taskList = taskList;
    }
}
