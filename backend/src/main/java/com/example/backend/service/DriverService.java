package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.DriverDTO;
import com.example.backend.model.City;
import com.example.backend.model.Driver;
import com.example.backend.model.Seat;

import java.time.LocalDate;
import java.util.List;

public interface DriverService {
    Driver createDriver(DriverDTO driverDTO);
    List<Driver> getAllDriver();
    Driver getDriverByID(int id);
    Driver updateDriverByID(DriverDTO driverDTO, int id);
    void deleteDriverByID(int id);
    Page<Driver> getAllDriverPage(String name, String email, String phone, Pageable pageable);
    List<Driver> findAvailableDrivers(LocalDate dayStart);
}
