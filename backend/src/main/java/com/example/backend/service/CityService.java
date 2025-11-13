package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import com.example.backend.dto.CityDTO;
import com.example.backend.model.City;
import com.example.backend.model.Seat;
import com.example.backend.model.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface CityService {
    City createCity(CityDTO cityDTO, MultipartFile file) throws IOException, GeneralSecurityException;
    List<City> getAllCity();
    City getCityByID(int id);
    City updateCityByID(CityDTO cityDTO, MultipartFile file, int id) throws IOException, GeneralSecurityException;
    void deleteCityByID(int id);
    Page<City> getAllCityPage(String name, Pageable pageable);
}
