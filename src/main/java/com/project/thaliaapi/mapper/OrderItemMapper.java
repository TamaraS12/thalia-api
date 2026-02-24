package com.project.thaliaapi.mapper;

import com.project.thaliaapi.dto.OrderItemDto;
import com.project.thaliaapi.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements GenericMapper<OrderItemDto, OrderItem> {
    @Override
    public OrderItem toEntity(OrderItemDto dto) {
        return new OrderItem(dto.quantity(), dto.amount());
    }

    @Override
    public OrderItemDto toDto(OrderItem entity) {
        return new OrderItemDto(entity.getId(), entity.getBook().getId(), entity.getBook().getTitle(), entity.getQuantity(), entity.getAmount());
    }
}
