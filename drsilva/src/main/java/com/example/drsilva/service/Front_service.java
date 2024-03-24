package com.example.drsilva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.drsilva.exception.FrontServiceException;
import com.example.drsilva.interfaces.FrontInterface;
import com.example.drsilva.model.Front_model;
import com.example.drsilva.repository.FrontRepository;

@Service
public class Front_service implements FrontInterface {

    private FrontRepository frontRepository;

    @Autowired
    public Front_service(FrontRepository frontRepository) {
        this.frontRepository = frontRepository;
    }

    @Override
    public List<Front_model> obterTodosFrontModels() {
        try {
            return frontRepository.findAll();
        } catch (Exception e) {
            throw new FrontServiceException("Erro ao obter todos os registros.", e);
        }
    }

    @Override
    public Front_model obterFrontModelPeloId(Long id) {
        try {
            return frontRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new FrontServiceException("Erro ao obter o registro pelo ID.", e);
        }
    }

    @Override
    public Front_model salvaFront_model(Front_model front_model) {
        try {
            return frontRepository.save(front_model);
        } catch (DataIntegrityViolationException e) {
            throw new FrontServiceException("Erro de integridade de dados ao salvar o registro.", e);
        } catch (Exception e) {
            throw new FrontServiceException("Erro ao salvar o registro.", e);
        }
    }

    @Override
    public void deletarFront_model(Long id) {
        try {
            frontRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new FrontServiceException("Erro de integridade de dados ao excluir o registro.", e);
        } catch (Exception e) {
            throw new FrontServiceException("Erro ao excluir o registro.", e);
        }
    }

	@Override
	public Front_model editarDado(Long id, Front_model novo_frontModel) {
	
		try {
			Front_model fM = frontRepository.findById(id).orElseThrow(() -> new FrontServiceException("Registro não encontrado"));
		    
			fM.setNome(novo_frontModel.getNome());
			fM.setIdade(novo_frontModel.getIdade());
			fM.setSalario(novo_frontModel.getSalario());
			fM.setDatanascimento(novo_frontModel.getDatanascimento());
			fM.setGenero(novo_frontModel.getGenero());
			fM.setFormacao(novo_frontModel.getFormacao());
			fM.setListafruta(novo_frontModel.getListafruta());
			
			return frontRepository.save(fM);
		
		} catch (DataIntegrityViolationException e) {
			 throw new FrontServiceException("Erro de integridade de dados ao editar o registro.", e);
		
		}  catch (Exception e) {
			throw new FrontServiceException("Erro ao editar o registro.", e);
			
		}
	}
}
