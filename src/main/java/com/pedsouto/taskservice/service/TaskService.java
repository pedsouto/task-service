package com.pedsouto.taskservice.service;

import com.pedsouto.taskservice.dto.TaskDto;
import com.pedsouto.taskservice.infra.entity.Task;
import com.pedsouto.taskservice.infra.enums.NotificationStatus;
import com.pedsouto.taskservice.infra.repository.TaskRepository;
import com.pedsouto.taskservice.infra.security.JwtUtil;
import com.pedsouto.taskservice.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final JwtUtil jwtUtil;

    @Transactional
    public TaskDto saveTask(String token, TaskDto taskDto) {
        String email = jwtUtil.extractUsername(token.substring(7));
        taskDto.setUserEmail(email);
        taskDto.setCreatedAt(LocalDateTime.now());
        taskDto.setNotificationStatus(NotificationStatus.PENDING);

        Task task = taskMapper.toEntity(taskDto);
        return taskMapper.toDto(taskRepository.save(task));
    }
}
