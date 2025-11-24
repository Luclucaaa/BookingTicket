package com.example.backend.service.impl;

import org.checkerframework.checker.units.qual.t;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.backend.dto.CityDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.CatchPoint;
import com.example.backend.model.City;
import com.example.backend.repository.CityRepository;
import com.example.backend.repository.specification.CatchPointSpecification;
import com.example.backend.repository.specification.CitySpecification;
import com.example.backend.service.CityService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private final Path fileStorageLocation = Paths.get("src/main/resources/static/img").toAbsolutePath().normalize();

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public City createCity(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        city.setCreatedAt(LocalDateTime.now());
        city.setUpdatedAt(LocalDateTime.now());
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityByID(int id) {
        return cityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", id));
    }

    @Override
    public City updateCityByID(CityDTO cityDTO, int id) {
        City existingCity = cityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", id));
        existingCity.setName(cityDTO.getName());
        existingCity.setUpdatedAt(LocalDateTime.now());
        return cityRepository.save(existingCity);
    }

    @Override
    public void deleteCityByID(int id) {
        cityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", id));
        cityRepository.deleteById(id);
    }

    @Override
    public Page<City> getAllCityPage(String name, Pageable pageable) {
        Specification<City> spec = Specification.where(CitySpecification.hasName(name));
        return cityRepository.findAll(spec, pageable);
    }
}
