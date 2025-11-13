package com.example.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.backend.dto.SeatReservationDTO;
import com.example.backend.dto.WaitingSeatDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.*;
import com.example.backend.repository.*;
import com.example.backend.service.SeatReservationService;
import com.example.backend.service.WaitingSeatService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaitingSeatServiceImpl implements WaitingSeatService {
    private SeatReservationRepository seatReservationRepository;
    private WaitingSeatRepository waitingSeatRepository;
    private SeatRepository seatRepository;
    private TripRepository tripRepository;

    public WaitingSeatServiceImpl(WaitingSeatRepository waitingSeatRepository, SeatRepository seatRepository, TripRepository tripRepository) {
        this.waitingSeatRepository = waitingSeatRepository;
        this.seatRepository = seatRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public WaitingSeat createWaitingSeat(WaitingSeatDTO waitingSeatDTO) {
        WaitingSeat waitingSeat = new WaitingSeat();
        Trip trip =  tripRepository.findById(waitingSeatDTO.getTripId()).orElseThrow(() ->
                new ResourceNotFoundException("Trip", "Id", waitingSeatDTO.getTripId()));
        Seat seat =  seatRepository.findById(waitingSeatDTO.getSeatId()).orElseThrow(() ->
                new ResourceNotFoundException("Booking", "Id", waitingSeatDTO.getSeatId()));
        waitingSeat.setTrip(trip);
        waitingSeat.setSeat(seat);
        waitingSeat.setCreatedAt(LocalDateTime.now());
        return waitingSeatRepository.save(waitingSeat);
    }

    @Override
    public List<WaitingSeat> getWaitingSeatsByTripId(int tripId) {
        return waitingSeatRepository.findByTrip_Id(tripId);
    }

    @Override
    public void deleteWaitingSeatsBatch(int tripId, List<Integer> seatIds) {
        waitingSeatRepository.deleteByTripIdAndSeatIds(tripId, seatIds);
    }

    @Override
    public List<WaitingSeat> getAllWaitingSeat() {
        return waitingSeatRepository.findAll();
    }

    @Override
    public WaitingSeat getWaitingSeatByID(int id) {
        return waitingSeatRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("WaitingSeat", "Id", id));
    }

    @Override
    public WaitingSeat updateWaitingSeatByID(WaitingSeatDTO waitingSeatDTO, int id) {
        return null;
    }

    @Override
    public void deleteWaitingSeatByID(int id) {
        waitingSeatRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("WaitingSeat", "Id", id));
        waitingSeatRepository.deleteById(id);
    }

    @Override
    public void deleteWaitingSeatByTripAndSeatId(WaitingSeatDTO waitingSeatDTO) {
        WaitingSeat waitingSeat = waitingSeatRepository.findByTripIdAndSeatId(waitingSeatDTO.getTripId(), waitingSeatDTO.getSeatId()).orElseThrow(() ->
                new ResourceNotFoundException("WaitingSeat", "TripId and SeatId", waitingSeatDTO.getTripId() + " and " + waitingSeatDTO.getSeatId()));
        waitingSeatRepository.delete(waitingSeat);
    }
}
