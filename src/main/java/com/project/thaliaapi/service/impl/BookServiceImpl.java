package com.project.thaliaapi.service.impl;

import com.project.thaliaapi.dto.BookDto;
import com.project.thaliaapi.dto.BookSearchRequest;
import com.project.thaliaapi.dto.SearchResponse;
import com.project.thaliaapi.mapper.BookMapper;
import com.project.thaliaapi.model.Book;
import com.project.thaliaapi.repository.BookRepository;
import com.project.thaliaapi.service.BookService;
import com.project.thaliaapi.specification.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public SearchResponse<BookDto> search(BookSearchRequest request, Pageable pageable) {
        Page<BookDto> page = bookRepository.findAll(BookSpecification.search(request), pageable)
                .map(book -> bookMapper.toDto(book));

        return new SearchResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public BookDto getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return bookMapper.toDto(book.get());
        }
        throw new RuntimeException("Book not found");
    }
}
