package com.example.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.backend.dto.RouteDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.City;
import com.example.backend.model.KindVehicle;
import com.example.backend.model.Route;
import com.example.backend.model.Trip;
import com.example.backend.repository.CityRepository;
import com.example.backend.repository.RouteRepository;
import com.example.backend.repository.specification.RouteSpecification;
import com.example.backend.repository.specification.TripSpecifications;
import com.example.backend.service.RouteService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private CityRepository cityRepository;

//    public RouteServiceImpl(RouteRepository routeRepository) {
//        this.routeRepository = routeRepository;
//    }

    public RouteServiceImpl(RouteRepository routeRepository, CityRepository cityRepository) {
        this.routeRepository = routeRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Route createRoute(RouteDTO routeDTO) {
        Route route = new Route();
        City diemdi = cityRepository.findById(routeDTO.getDiemdi()).orElseThrow(() ->
                new ResourceNotFoundException("City1", "Id", routeDTO.getDiemdi()));
        City diemden = cityRepository.findById(routeDTO.getDiemden()).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", routeDTO.getDiemden()));
        route.setName(routeDTO.getName());
        route.setDiemDi(diemdi);
        route.setDiemDen(diemden);
        route.setKhoangCach(routeDTO.getKhoangCach());
        route.setTimeOfRoute(routeDTO.getTimeOfRoute());
        route.setStatus(routeDTO.getStatus());
        route.setCreatedAt(LocalDateTime.now());
        route.setUpdatedAt(LocalDateTime.now());
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }

    @Override
    public Route getRouteByID(int id) {
        return routeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Route", "Id", id));
    }

    @Override
    public Route updateRouteByID(RouteDTO routeDTO, int id) {
        Route existingRoute = routeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Route", "Id", id));
        City diemdi = cityRepository.findById(routeDTO.getDiemdi()).orElseThrow(() ->
                new ResourceNotFoundException("City1", "Id", routeDTO.getDiemdi()));
        City diemden = cityRepository.findById(routeDTO.getDiemden()).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", routeDTO.getDiemden()));
        existingRoute.setName(routeDTO.getName());
        existingRoute.setDiemDi(diemdi);
        existingRoute.setDiemDen(diemden);
        existingRoute.setKhoangCach(routeDTO.getKhoangCach());
        existingRoute.setTimeOfRoute(routeDTO.getTimeOfRoute());
        existingRoute.setStatus(routeDTO.getStatus());
        existingRoute.setUpdatedAt(LocalDateTime.now());
        return routeRepository.save(existingRoute);
    }

    @Override
    public void deleteRouteByID(int id) {
        routeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Route", "Id", id));
        routeRepository.deleteById(id);
    }

    @Override
    public Page<Route> getAllRoutePage(
            String name,
            String khoangCach,
            String timeOfRoute,
            Integer status,
            Integer diemdi,
            Integer diemden,
            Pageable pageable) {

        Specification<Route> spec = Specification
                .where(RouteSpecification.hasName(name))
                .and(RouteSpecification.hasKhoangCach(khoangCach))
                .and(RouteSpecification.hasTimeOfRoute(timeOfRoute))
                .and(RouteSpecification.hasStatus(status))
                .and(RouteSpecification.hasDiemDi(diemdi))
                .and(RouteSpecification.hasDiemDen(diemden));

        return routeRepository.findAll(spec, pageable);
    }



    @Override
    public List<Route> getActiveRoutes() {
        return routeRepository.findByStatus(1);
    }
}
