package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteSeatsRequest {
    private int tripId;
    private List<Integer> seatIds;
}