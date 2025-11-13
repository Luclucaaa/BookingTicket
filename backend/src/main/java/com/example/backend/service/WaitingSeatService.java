package com.example.backend.service;


import com.example.backend.dto.WaitingSeatDTO;
import com.example.backend.model.WaitingSeat;

import java.util.List;

public interface WaitingSeatService {
    WaitingSeat createWaitingSeat(WaitingSeatDTO waitingSeatDTO);
    List<WaitingSeat> getAllWaitingSeat();
    WaitingSeat getWaitingSeatByID(int id);
    WaitingSeat updateWaitingSeatByID(WaitingSeatDTO waitingSeatDTO, int id);
    void deleteWaitingSeatByID(int id);
    void deleteWaitingSeatByTripAndSeatId(WaitingSeatDTO waitingSeatDTO);
    List<WaitingSeat> getWaitingSeatsByTripId(int tripId);
    public void deleteWaitingSeatsBatch(int tripId, List<Integer> seatIds);
}
