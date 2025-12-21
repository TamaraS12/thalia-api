package com.project.thaliaapi.controller;

import com.project.thaliaapi.dto.BookSearchRequest;
import com.project.thaliaapi.dto.BookDto;
import com.project.thaliaapi.dto.SearchResponse;
import com.project.thaliaapi.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public SearchResponse<BookDto> search(
            BookSearchRequest request,
            @PageableDefault(size = 10, sort = "title") Pageable pageable
    ) {
        return bookService.search(request, pageable);
    }
}
