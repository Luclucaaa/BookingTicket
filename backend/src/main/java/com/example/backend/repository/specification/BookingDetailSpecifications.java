package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.BookingDetail;

public class BookingDetailSpecifications {
    public static Specification<BookingDetail> hasId(String id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
}
