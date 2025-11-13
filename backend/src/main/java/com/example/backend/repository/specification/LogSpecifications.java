package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.Booking;
import com.example.backend.model.City;
import com.example.backend.model.Log;

public class LogSpecifications {
    public static Specification<Log> hasId(Integer id) {
        return (root, query, criteriaBuilder) ->
                id == null ? null : criteriaBuilder.equal(root.get("id"), id);
    }


    public static Specification<Log> hasUserUserName(String userName) {
        return (root, query, criteriaBuilder) ->
                userName == null ? null : criteriaBuilder.like(root.get("user").get("name"), "%" + userName + "%");
    }
//    public static Specification<City> hasName(String name) {
//        return (root, query, criteriaBuilder) ->
//                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
//    }

    public static Specification<Log> hasIsLevel(Integer level) {
        return (root, query, criteriaBuilder) ->
                level == null ? null : criteriaBuilder.equal(root.get("level"), level);
    }
}
