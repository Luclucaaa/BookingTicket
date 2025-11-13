package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.SeatReservationDTO;
import com.example.backend.model.Seat;
import com.example.backend.model.SeatReservation;

import java.util.List;

public interface SeatReservationService {
    SeatReservation createSeatReservation(SeatReservationDTO seatReservationDTO);
    List<SeatReservation> getAllSeatReservation();
    SeatReservation getSeatReservationByID(int id);
    SeatReservation updateSeatReservationByID(SeatReservation seatReservation, int id);
    void deleteSeatReservationByID(int id);
    List<SeatReservation> getSeatReservationsByTripId(int tripId);
    List<SeatReservation> getSeatReservationsByBookingId(int bookingId);
    void deleteSeatReservationsByBookingId(int bookingId);
    Page<SeatReservation> getAllSeatReservationPage(String name, Pageable pageable);
}
