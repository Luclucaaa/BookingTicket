package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.example.backend.model.CatchPoint;

import java.util.List;

@Repository
public interface CatchPointRepository extends JpaRepository<CatchPoint, Integer>, JpaSpecificationExecutor<CatchPoint> {
    List<CatchPoint> findByRouteId(int routeId);
}
