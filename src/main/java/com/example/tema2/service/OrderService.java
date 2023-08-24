package com.example.tema2.service;

import com.example.tema2.model.Flower;
import com.example.tema2.model.Order;
import com.example.tema2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final FlowerService flowerService;

    public void placeOrder(Long flowerId, Long quantity) {
        Flower flower = flowerService.getFlowerById(flowerId);

        if (flower.getStock() >= quantity) {
            flower.setStock(flower.getStock() - quantity);
            Order order = new Order();
            order.setFlowerId(flowerId);
            order.setQty(quantity);
            order.setOrderPrice(quantity * flower.getPrice());

            orderRepository.save(order);
            flowerService.saveFlower(flower);
        }

        else {
            log.warn("Not enough quantity");
            throw new IllegalArgumentException();
        }
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
