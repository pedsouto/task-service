package com.pedsouto.taskservice.infra.repository;

import com.pedsouto.taskservice.infra.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
