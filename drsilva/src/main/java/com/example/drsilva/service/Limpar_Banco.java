package com.example.drsilva.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.drsilva.model.Front_model;
import com.example.drsilva.repository.FrontRepository;

@Component
public class Limpar_Banco {

    @Autowired
    FrontRepository frontRepository;

    @Scheduled(fixedRate = 3600000) // Executa a cada hora
    public void LimparBanco() {
        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaExpiracao = horaAtual.minus(1, ChronoUnit.HOURS);

        List<Front_model> registroExpirado = frontRepository.findByDataCriacaoBefore(horaExpiracao);

        for (Front_model registro: registroExpirado) {
            frontRepository.delete(registro);
        }

    }
    
}
