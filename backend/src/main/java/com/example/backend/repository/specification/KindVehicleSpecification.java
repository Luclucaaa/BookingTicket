package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.KindVehicle;
import com.example.backend.model.User;

public class KindVehicleSpecification {
    public static Specification<KindVehicle> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

}
