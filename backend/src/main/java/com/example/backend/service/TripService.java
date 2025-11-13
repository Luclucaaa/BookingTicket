package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.TripDTO;
import com.example.backend.dto.TripSearchDTO;
import com.example.backend.model.Seat;
import com.example.backend.model.Trip;

import java.time.LocalDate;
import java.util.List;

public interface TripService {
    Trip createTrip(TripDTO tripDTO);
    List<Trip> getAllTrip();
    Trip getTripByID(int id);
    Trip updateTripByID(TripDTO tripDTO, int id);
    void deleteTripByID(int id);
    List<Trip> searchTrips(TripSearchDTO tripSearchDTO);
    Page<Trip> getAllTripPage(Pageable pageable);
    Page<Trip> getTrips(Integer routeId, LocalDate dayStart, Pageable pageable);
    void updateTripSeats(int tripId, List<Integer> seatIds);
}
