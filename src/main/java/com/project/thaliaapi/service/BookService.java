package com.project.thaliaapi.service;

import com.project.thaliaapi.dto.BookDto;
import com.project.thaliaapi.dto.BookSearchRequest;
import com.project.thaliaapi.dto.SearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    SearchResponse<BookDto> search(BookSearchRequest request, Pageable pageable);
}
