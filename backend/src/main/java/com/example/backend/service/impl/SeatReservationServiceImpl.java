package com.example.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.backend.dto.SeatReservationDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Booking;
import com.example.backend.model.Seat;
import com.example.backend.model.SeatReservation;
import com.example.backend.model.Trip;
import com.example.backend.repository.BookingRepository;
import com.example.backend.repository.SeatRepository;
import com.example.backend.repository.SeatReservationRepository;
import com.example.backend.repository.TripRepository;
import com.example.backend.repository.specification.SeatReservationSpecifications;
import com.example.backend.repository.specification.TripSpecifications;
import com.example.backend.service.SeatReservationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {
    private SeatReservationRepository seatReservationRepository;
    private BookingRepository bookingRepository;
    private SeatRepository seatRepository;
    private TripRepository tripRepository;

    public SeatReservationServiceImpl(SeatReservationRepository seatReservationRepository, BookingRepository bookingRepository, SeatRepository seatRepository, TripRepository tripRepository) {
        this.seatReservationRepository = seatReservationRepository;
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public SeatReservation createSeatReservation(SeatReservationDTO seatReservationDTO) {
        SeatReservation seatReservation = new SeatReservation();
        Booking booking =  bookingRepository.findById(seatReservationDTO.getBookingId()).orElseThrow(() ->
                new ResourceNotFoundException("Booking", "Id", seatReservationDTO.getBookingId()));
        Seat seat =  seatRepository.findById(seatReservationDTO.getSeatId()).orElseThrow(() ->
                new ResourceNotFoundException("Booking", "Id", seatReservationDTO.getSeatId()));
        Trip trip =  tripRepository.findById(seatReservationDTO.getTripId()).orElseThrow(() ->
                new ResourceNotFoundException("Trip", "Id", seatReservationDTO.getTripId()));
        seatReservation.setBooking(booking);
        seatReservation.setTrip(trip);
        seatReservation.setSeat(seat);
        seatReservation.setStatus(1);
        seatReservation.setCreatedAt(LocalDateTime.now());
        seatReservation.setUpdatedAt(LocalDateTime.now());
        return seatReservationRepository.save(seatReservation);
    }
    //tìm kiếm theo chuyến
//    @Override
//    public List<SeatReservation> getSeatReservationsByTripId(int tripId) {
//        return seatReservationRepository.findByBooking_Trip_Id(tripId);
//    }

    @Override
    public List<SeatReservation> getSeatReservationsByTripId(int tripId) {
        return seatReservationRepository.findByTrip_Id(tripId);
    }

    @Override
    public List<SeatReservation> getSeatReservationsByBookingId(int bookingId) {
        return seatReservationRepository.findByBooking_Id(bookingId);
    }

    @Override
    public List<SeatReservation> getAllSeatReservation() {
        return seatReservationRepository.findAll();
    }

    @Override
    public SeatReservation getSeatReservationByID(int id) {
        return seatReservationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SeatReservation", "Id", id));
    }

    @Override
    public SeatReservation updateSeatReservationByID(SeatReservation seatReservation, int id) {
        return null;
    }

    @Override
    public void deleteSeatReservationByID(int id) {
        seatReservationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SeatReservation", "Id", id));
        seatReservationRepository.deleteById(id);
    }

    // xóa theo bookingId
    @Override
    public void deleteSeatReservationsByBookingId(int bookingId) {
        List<SeatReservation> seatReservations = seatReservationRepository.findByBooking_Id(bookingId);
        if (seatReservations != null && !seatReservations.isEmpty()) {
            seatReservationRepository.deleteAll(seatReservations);
        } else {
            throw new ResourceNotFoundException("Seat Reservations", "Booking Id", bookingId);
        }
    }

    @Override
    public Page<SeatReservation> getAllSeatReservationPage(String name, Pageable pageable) {
        Specification<SeatReservation> spec = Specification.where(SeatReservationSpecifications.hasName(name));
        return seatReservationRepository.findAll(spec, pageable);
    }
}
