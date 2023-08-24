package com.example.tema2.controller;

import com.example.tema2.model.Order;
import com.example.tema2.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "Place an order", description = "Give a flower id and a quantity")
    @PostMapping
    public void buyFlower(@RequestParam("flowerId") Long flowerId, @RequestParam("quantity") Long quantity) {
        orderService.placeOrder(flowerId, quantity);
    }

    @Operation(summary = "Get all orders")
    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAll();
    }
}
