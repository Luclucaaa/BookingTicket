package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.CityDTO;
import com.example.backend.model.City;

import java.util.List;

public interface CityService {
    City createCity(CityDTO cityDTO);
    List<City> getAllCity();
    City getCityByID(int id);
    City updateCityByID(CityDTO cityDTO, int id);
    void deleteCityByID(int id);
    Page<City> getAllCityPage(String name, Pageable pageable);
}
