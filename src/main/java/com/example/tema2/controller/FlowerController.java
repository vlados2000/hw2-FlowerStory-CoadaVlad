package com.example.tema2.controller;


import com.example.tema2.model.Flower;
import com.example.tema2.service.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/flowers")
@RequiredArgsConstructor
public class FlowerController {
    private final FlowerService flowerService;

    @Operation(summary = "List all flowers")
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getAllFlowers();
    }

    @Operation(summary = "Create a flower")
    @PostMapping
    public void addFlower(@RequestBody Flower flower) {
        flowerService.createFlower(flower);
    }

    @Operation(summary = "Update a flower by id", description = "Update flower stock or price by id, by the given query params")
    @PutMapping("/{id}")
    public void updateFlowerStocOrPrice(
            @PathVariable Long id,
            @RequestParam(required = false) Long stoc,
            @RequestParam(required = false) Long price) {
        flowerService.updateFlowerStocOrPrice(id, stoc, price);
    }




}
