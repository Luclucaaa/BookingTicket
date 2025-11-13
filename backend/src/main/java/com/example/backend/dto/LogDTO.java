package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.model.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogDTO {
    private int id;
    private int userId;
    private String message;
    private int level;
    private LocalDateTime createdAt = LocalDateTime.now();
}
