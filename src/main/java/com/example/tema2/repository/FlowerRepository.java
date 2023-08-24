package com.example.tema2.repository;

import com.example.tema2.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    Optional<Flower> getFlowerById(Long id);
}
