package com.mondi.intgress.controllers;

import com.mondi.intgress.dtos.TaskDto;
import com.mondi.intgress.models.TaskListModel;
import com.mondi.intgress.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/task-lists")
public class TasksController {

    @Autowired
    private TaskService taskListService;

//    @PostMapping
//    public ResponseEntity<TaskDto> createTaskList(@RequestBody @Valid TaskDto taskListDto) {
//        TaskListModel taskList = taskListService.createTaskList(taskListDto);
//
//        return ResponseEntity.ok(taskList.toDto());
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TaskDto> updateTaskList(@PathVariable UUID id, @RequestBody @Valid TaskDto taskListDto) {
//        taskListDto.setId(id);
//
//        TaskListModel taskList = taskListService.updateTaskList(taskListDto);
//
//        return ResponseEntity.ok(taskList.toDto());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable UUID id) {
        taskListService.deleteTaskList(id);

        return ResponseEntity.noContent().build();
    }
}
