package com.project.thaliaapi.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderDto(Long id,
                       String country,
                       String city,
                       String address,
                       List<OrderItemDto> items,
                       BigDecimal totalAmount) {
}
