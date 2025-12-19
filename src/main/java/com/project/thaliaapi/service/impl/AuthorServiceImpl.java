package com.project.thaliaapi.service.impl;

import com.project.thaliaapi.dto.AuthorDto;
import com.project.thaliaapi.mapper.AuthorMapper;
import com.project.thaliaapi.model.Author;
import com.project.thaliaapi.repository.AuthorRepository;
import com.project.thaliaapi.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> getAll() {
        List<Author> authors = authorRepository.findAll();

        return authors.stream()
                .map(author -> authorMapper.toDto(author))
                .toList();
    }
}
