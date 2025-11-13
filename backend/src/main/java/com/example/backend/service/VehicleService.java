package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.VehicleDTO;
import com.example.backend.model.Seat;
import com.example.backend.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(VehicleDTO vehicleDTO);
    List<Vehicle> getAllVehicle();
    Vehicle getVehicleByID(int id);
    Vehicle updateVehicleByID(VehicleDTO vehicleDTO, int id);
    void deleteVehicleByID(int id);
    List<Vehicle> getVehiclesByKindVehicleId(int kindVehicleId);
    List<Vehicle> findAvailableVehiclesByKindVehicleId(int kindVehicleId, LocalDate dayStart);
    public Page<Vehicle> getAllVehiclePage(String name, Integer kindVehicleId, String vehicleNumber, Integer value, Integer status, Pageable pageable);
}
