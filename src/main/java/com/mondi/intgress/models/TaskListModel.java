package com.mondi.intgress.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TaskListModel")
public class TaskListModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private TaskListCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskList")
    private List<TaskModel> items;

    private LocalDateTime createdAt;
    private Boolean completed;

    public TaskListModel() {
    }

    public TaskListModel(String title, TaskListCategory category, List<TaskModel> items, LocalDateTime createdAt, Boolean completed) {
        this.title = title;
        this.category = category;
        this.items = items;
        this.createdAt = createdAt;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskListCategory getCategory() {
        return category;
    }

    public void setCategory(TaskListCategory category) {
        this.category = category;
    }

    public List<TaskModel> getItems() {
        return items;
    }

    public void setItems(List<TaskModel> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

