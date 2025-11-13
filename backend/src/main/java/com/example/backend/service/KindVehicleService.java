package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.KindVehicleDTO;
import com.example.backend.model.Contact;
import com.example.backend.model.Driver;
import com.example.backend.model.KindVehicle;

import java.util.List;

public interface KindVehicleService {
    KindVehicle createKindVehicle(KindVehicleDTO kindVehicleDTO);
    List<KindVehicle> getAllKindVehicle();
    KindVehicle getKindVehicleByID(int id);
    KindVehicle updateKindVehicleByID(KindVehicleDTO kindVehicleDTO, int id);
    void deleteKindVehicleByID(int id);
    Page<KindVehicle> getAllKindVehiclePage(String name, Pageable pageable);
}
