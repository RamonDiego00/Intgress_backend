package com.mondi.intgress.repository;

import com.mondi.intgress.models.TaskModel;
import com.mondi.intgress.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
}
