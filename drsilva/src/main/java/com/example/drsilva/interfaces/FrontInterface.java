package com.example.drsilva.interfaces;

import java.util.List;

import com.example.drsilva.model.Front_model;

public interface FrontInterface {

    List <Front_model> obterTodosFrontModels();
    
    Front_model obterFrontModelPeloId(Long id);

    Front_model salvaFront_model(Front_model front_model);
    
    Front_model editarDado(Long id, Front_model novo_frontModel);

    void deletarFront_model(Long id);


    
}
