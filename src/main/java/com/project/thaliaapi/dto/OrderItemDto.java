package com.project.thaliaapi.dto;

import java.math.BigDecimal;

public record OrderItemDto(Long id, Long bookId, Integer quantity, BigDecimal amount) {
}
