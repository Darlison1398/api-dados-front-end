package com.example.drsilva.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.drsilva.model.Front_model;

public interface FrontRepository extends JpaRepository <Front_model, Long> {
    List<Front_model> findByDataCriacaoBefore(LocalDateTime dataCriacao);
}
