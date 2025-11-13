package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.LogDTO;
import com.example.backend.model.Log;
import com.example.backend.model.Seat;

import java.util.List;

public interface LogService {
    Log createLog(LogDTO logDTO);
    List<Log> getAllLog();
    Log getLogByID(int id);
    Page<Log> getAllLogPage(String userName, Integer level, Pageable pageable);
    List<Log> getLogsByUserId(int userId);
    LogDTO convertToLogDTO(int userId, String message, int level);
}
