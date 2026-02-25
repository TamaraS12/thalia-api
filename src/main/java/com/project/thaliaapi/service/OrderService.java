package com.project.thaliaapi.service;

import com.project.thaliaapi.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto add(OrderDto orderDto, String username);

    List<OrderDto> getAllByUser(String username);
}
