package com.project.thaliaapi.mapper;

import com.project.thaliaapi.dto.GenreDto;
import com.project.thaliaapi.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements GenericMapper<GenreDto, Genre> {
    @Override
    public Genre toEntity(GenreDto dto) {
        return new Genre(dto.id(), dto.name());
    }

    @Override
    public GenreDto toDto(Genre entity) {
        return new GenreDto(entity.getId(), entity.getName());
    }
}
