package com.project.thaliaapi.controller;

import com.project.thaliaapi.dto.OrderDto;
import com.project.thaliaapi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDto add(@RequestBody OrderDto order) {
        return orderService.add(order);
    }

    @GetMapping
    public List<OrderDto> getAll(){
        return orderService.getAll();
    }
}
