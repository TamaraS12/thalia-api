package com.project.thaliaapi.service;

import com.project.thaliaapi.dto.BookDto;
import com.project.thaliaapi.dto.BookSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<BookDto> search(BookSearchRequest request, Pageable pageable);
    BookDto getById(Long id);
}
