package com.project.thaliaapi.service.impl;

import com.project.thaliaapi.dto.OrderDto;
import com.project.thaliaapi.mapper.OrderItemMapper;
import com.project.thaliaapi.mapper.OrderMapper;
import com.project.thaliaapi.model.Book;
import com.project.thaliaapi.model.Order;
import com.project.thaliaapi.model.OrderItem;
import com.project.thaliaapi.repository.BookRepository;
import com.project.thaliaapi.repository.OrderRepository;
import com.project.thaliaapi.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BookRepository bookRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, BookRepository bookRepository, OrderItemMapper orderItemMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.bookRepository = bookRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public OrderDto add(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);

        List<OrderItem> orderItems = orderDto.items().stream()
                .map(item -> {
                    OrderItem orderItemEntity = orderItemMapper.toEntity(item);
                    Book bookEntity = bookRepository.findById(item.bookId())
                            .orElseThrow(() -> new RuntimeException("Book not found"));

                    orderItemEntity.setBook(bookEntity);
                    return orderItemEntity;
                })
                .toList();

        order.setItems(orderItems);
        order.setOrderDate(LocalDate.now());

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> orderMapper.toDto(order)).toList();
    }
}
