package com.example.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.backend.dto.KindVehicleDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.KindVehicle;
import com.example.backend.model.Trip;
import com.example.backend.repository.KindVehicleRepository;
import com.example.backend.repository.specification.KindVehicleSpecification;
import com.example.backend.repository.specification.TripSpecifications;
import com.example.backend.service.KindVehicleService;
import com.example.backend.service.KindVehicleService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KindVehicleServiceImpl implements KindVehicleService {
    private KindVehicleRepository kindVehicleRepository;

    public KindVehicleServiceImpl(KindVehicleRepository kindVehicleRepository) {
        this.kindVehicleRepository = kindVehicleRepository;
    }

    @Override
    public KindVehicle createKindVehicle(KindVehicleDTO kindVehicleDTO) {
        KindVehicle kindVehicle = new KindVehicle();
        kindVehicle.setName(kindVehicleDTO.getName());
        kindVehicle.setCreatedAt(LocalDateTime.now());
        kindVehicle.setUpdatedAt(LocalDateTime.now());
        return kindVehicleRepository.save(kindVehicle);
    }

    @Override
    public List<KindVehicle> getAllKindVehicle() { return kindVehicleRepository.findAll();}

    @Override
    public KindVehicle getKindVehicleByID(int id) {
        return kindVehicleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("KindVehicle", "Id", id));
    }

    @Override
    public KindVehicle updateKindVehicleByID(KindVehicleDTO kindVehicleDTO, int id) {
        KindVehicle existingKindVehicle = kindVehicleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("KindVehicle", "Id", id));
        existingKindVehicle.setName(kindVehicleDTO.getName());
        existingKindVehicle.setUpdatedAt(LocalDateTime.now());
        return kindVehicleRepository.save(existingKindVehicle);
    }

    @Override
    public void deleteKindVehicleByID(int id) {
        kindVehicleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("KindVehicle", "Id", id));
        kindVehicleRepository.deleteById(id);
    }

    @Override
    public Page<KindVehicle> getAllKindVehiclePage(String name, Pageable pageable) {
        Specification<KindVehicle> spec = Specification.where(KindVehicleSpecification.hasName(name));
        return kindVehicleRepository.findAll(spec, pageable);
    }
}
