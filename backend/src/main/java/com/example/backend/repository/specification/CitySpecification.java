package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.City;
import com.example.backend.model.User;

public class CitySpecification {
    public static Specification<City> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }


}
