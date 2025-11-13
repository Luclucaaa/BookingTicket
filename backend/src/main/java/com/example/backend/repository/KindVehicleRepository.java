package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.example.backend.model.Driver;
import com.example.backend.model.KindVehicle;

@Repository
public interface KindVehicleRepository extends JpaRepository<KindVehicle, Integer>, JpaSpecificationExecutor<KindVehicle> {
}
