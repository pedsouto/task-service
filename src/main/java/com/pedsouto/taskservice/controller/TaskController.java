package com.pedsouto.taskservice.controller;

import com.pedsouto.taskservice.dto.TaskDto;
import com.pedsouto.taskservice.infra.enums.NotificationStatus;
import com.pedsouto.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(
            @RequestHeader("Authorization") String token,
            @RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(token, taskDto));
    }
}
