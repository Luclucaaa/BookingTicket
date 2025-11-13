package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.RouteDTO;
import com.example.backend.model.Route;
import com.example.backend.model.Seat;

import java.util.List;

public interface RouteService {
    Route createRoute(RouteDTO routeDTO);
    List<Route> getAllRoute();
    Route getRouteByID(int id);
    Route updateRouteByID(RouteDTO routeDTO, int id);
    void deleteRouteByID(int id);
    Page<Route> getAllRoutePage(
            String name,
            String khoangCach,
            String timeOfRoute,
            Integer status,
            Integer diemdi,
            Integer diemden,
            Pageable pageable);
    List<Route> getActiveRoutes();
}
