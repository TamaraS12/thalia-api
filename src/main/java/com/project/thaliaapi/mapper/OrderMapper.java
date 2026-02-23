package com.project.thaliaapi.mapper;

import com.project.thaliaapi.dto.OrderDto;
import com.project.thaliaapi.dto.OrderItemDto;
import com.project.thaliaapi.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper implements GenericMapper<OrderDto, Order> {
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public Order toEntity(OrderDto dto) {
        return new Order(dto.country(), dto.city(), dto.address(), dto.totalAmount());
    }

    @Override
    public OrderDto toDto(Order entity) {
        List<OrderItemDto> orderItems = entity.getItems().stream()
                .map(orderItem -> orderItemMapper.toDto(orderItem))
                .toList();

        return new OrderDto(entity.getId(), entity.getCountry(), entity.getCity(), entity.getAddress(), orderItems, entity.getTotalAmount());
    }
}
