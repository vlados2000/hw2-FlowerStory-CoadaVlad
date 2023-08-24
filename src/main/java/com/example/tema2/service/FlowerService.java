package com.example.tema2.service;

import com.example.tema2.model.Flower;
import com.example.tema2.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerService {
    private final FlowerRepository flowerRepository;

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public void createFlower(Flower flower) {
        flowerRepository.save(flower);
    }


    public void updateFlowerStocOrPrice(Long id, Long stoc, Long price) {
        Flower flower = getFlowerById(id);

        if (stoc != null) {
            flower.setStock(stoc);
        }

        if (price != null) {
            flower.setPrice(price);
        }

        flowerRepository.save(flower);
    }

    public Flower getFlowerById(Long flowerId) {
        return flowerRepository.getFlowerById(flowerId).orElseThrow(IllegalArgumentException::new);
    }

    public void saveFlower(Flower flower) {
        flowerRepository.save(flower);
    }
}
