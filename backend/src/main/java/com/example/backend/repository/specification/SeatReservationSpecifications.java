package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.Seat;
import com.example.backend.model.SeatReservation;

public class SeatReservationSpecifications {
    public static Specification<SeatReservation> hasId(Integer id) {
        return (root, query, criteriaBuilder) ->
                id == null ? null : criteriaBuilder.equal(root.get("id"), id);
    }


    public static Specification<SeatReservation> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("seat").get("name"), "%" + name + "%");
    }

}
