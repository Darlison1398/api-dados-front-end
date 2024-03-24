package com.example.drsilva.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.drsilva.model.Front_model;
import com.example.drsilva.service.Front_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/front")
public class Front_controller {

    private Front_service front_service;

    @Autowired
    public Front_controller(Front_service front_service) {
        this.front_service = front_service;
    }

    @GetMapping("/obterDados")
    public List<Front_model> obterTodosFrontModels() {
        return front_service.obterTodosFrontModels();
    }

    @GetMapping("/{id}")
    public Front_model obterFrontModelPeloId(@PathVariable Long id) {
        return front_service.obterFrontModelPeloId(id);
    }

    @PostMapping("/salvar")
    public Front_model salvaFront_model(@RequestBody Front_model front_model) {
        return front_service.salvaFront_model(front_model);
    }

    @DeleteMapping("/apagar/{id}")
    public void deleFront_model(@PathVariable Long id) {
        front_service.deletarFront_model(id);
    }
    
    @PutMapping("/editar/{id}")
    public Front_model editarDado(@PathVariable Long id, @RequestBody Front_model novo_frontModel) {
    	return front_service.editarDado(id, novo_frontModel);
    }
    
    
}
