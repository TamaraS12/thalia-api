package com.project.thaliaapi.dto;

import java.util.List;

public record SearchResponse<T>(List<T> content,
                                int page,
                                int size,
                                long totalElements,
                                int totalPages) {
}
