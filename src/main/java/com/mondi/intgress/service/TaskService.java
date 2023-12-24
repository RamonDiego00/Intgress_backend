package com.mondi.intgress.service;

import com.mondi.intgress.dtos.TaskDto;
import com.mondi.intgress.models.TaskListModel;
import com.mondi.intgress.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskListRepository;

//    public TaskListModel createTaskList(TaskDto taskListDto) {
//        TaskListModel taskList = TaskList.builder()
//                .title(taskListDto.getTitle())
//                .description(taskListDto.getDescription())
//                .category(taskListDto.getCategory())
//                .build();
//
//        taskListRepository.save(taskList);
//
//        return taskList;
//    }

//    public TaskListModel updateTaskList(TaskDto taskListDto) {
//        TaskListModel taskList = taskListRepository.findById(taskListDto.getId())
//                .orElseThrow(() -> new TaskListNotFoundException(taskListDto.getId()));
//
//        taskList.setTitle(taskListDto.getTitle());
//        taskList.setDescription(taskListDto.getDescription());
//        taskList.setCategory(taskListDto.getCategory());
//
//        taskListRepository.save(taskList);
//
//        return taskList;
//    }

    public void deleteTaskList(UUID id) {
        taskListRepository.deleteById(id);
    }
}
