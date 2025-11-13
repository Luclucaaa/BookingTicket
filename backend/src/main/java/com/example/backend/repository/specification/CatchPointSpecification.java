package com.example.backend.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.example.backend.model.CatchPoint;

public class CatchPointSpecification {

    public static Specification<CatchPoint> hasAddress(String address) {
        return (root, query, cb) ->
                (address == null || address.trim().isEmpty())
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("address")), "%" + address.toLowerCase() + "%");
    }

    public static Specification<CatchPoint> hasName(String name) {
        return (root, query, cb) ->
                (name == null || name.trim().isEmpty())
                        ? cb.conjunction()
                        : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<CatchPoint> hasRouteId(Integer routeId) {
        return (root, query, cb) ->
                (routeId == null)
                        ? cb.conjunction()
                        : cb.equal(root.get("route").get("id"), routeId);
    }
}
