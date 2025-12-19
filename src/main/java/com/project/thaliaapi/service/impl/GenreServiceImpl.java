package com.project.thaliaapi.service.impl;

import com.project.thaliaapi.dto.GenreDto;
import com.project.thaliaapi.mapper.GenreMapper;
import com.project.thaliaapi.model.Genre;
import com.project.thaliaapi.repository.GenreRepository;
import com.project.thaliaapi.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<GenreDto> getAll() {
        List<Genre> genres = genreRepository.findAll();

        return genres.stream()
                .map(genre -> genreMapper.toDto(genre))
                .toList();
    }
}
