package com.project.thaliaapi.repository;

import com.project.thaliaapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByUserId(Long userId);
}
