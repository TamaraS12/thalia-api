package com.project.thaliaapi.dto;

import java.math.BigDecimal;
import java.util.Set;

public record BookDto(Long id,
                      String title,
                      String imageUrl,
                      BigDecimal price,
                      String authorName,
                      Set<String> genres) {
}
