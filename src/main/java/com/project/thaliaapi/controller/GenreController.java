package com.project.thaliaapi.controller;

import com.project.thaliaapi.dto.GenreDto;
import com.project.thaliaapi.model.Genre;
import com.project.thaliaapi.repository.GenreRepository;
import com.project.thaliaapi.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDto> getAll() {
        return genreService.getAll();
    }
}
