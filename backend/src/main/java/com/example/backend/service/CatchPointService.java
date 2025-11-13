package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.CatchPointDTO;
import com.example.backend.dto.ReviewDTO;
import com.example.backend.model.CatchPoint;
import com.example.backend.model.Review;

import java.util.List;

public interface CatchPointService {
    CatchPoint createCatchPoint(CatchPointDTO catchPointDTO);
    List<CatchPoint> getAllCatchPoint();
    CatchPoint getCatchPointByID(int id);
    CatchPoint updateCatchPointByID(CatchPointDTO catchPointDTO, int id);
    void deleteCatchPointByID(int id);
    Page<CatchPoint> getAllCatchPointPage(String address, String name, Integer routeId, Pageable pageable);
    List<CatchPoint> getCatchPointsByRouteId(int routeId);
}
