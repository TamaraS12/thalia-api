package com.project.thaliaapi.mapper;

import com.project.thaliaapi.dto.AuthorDto;
import com.project.thaliaapi.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements GenericMapper<AuthorDto, Author> {
    @Override
    public Author toEntity(AuthorDto dto) {
        return new Author(dto.id(), dto.name());
    }

    @Override
    public AuthorDto toDto(Author entity) {
        return new AuthorDto(entity.getId(), entity.getName());
    }
}
