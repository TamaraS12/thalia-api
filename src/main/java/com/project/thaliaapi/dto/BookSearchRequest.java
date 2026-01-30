package com.project.thaliaapi.dto;

public record BookSearchRequest(String title,
                                Long authorId,
                                Long genreId,
                                String sort) {
}
