package com.locadora.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.locadora.backend.model.Ator;
import com.locadora.backend.repository.AtorRepository;

@Service
public class AtorService {
    @Autowired
    private AtorRepository atorRepository;

    // Lista todos os atores
    public List<Ator> listar() {
        return atorRepository.findAll();
    }

    // Cadastra um novo ator
    public Ator cadastrar(Ator ator) {
        return atorRepository.save(ator);
    }

    // Atualiza um ator existente
    public Ator atualizar(Long id, Ator ator) {

        Ator atorExistente = atorRepository.findById(id).orElse(null);

        if (atorExistente == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ator não encontrado"
            );
        }

        atorExistente.setNome(ator.getNome());

        return atorRepository.save(atorExistente);
    }

    // Exclui um ator
    public void excluir(Long id) {

        if (!atorRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ator não encontrado"
            );
        }

        atorRepository.deleteById(id);
    }
}