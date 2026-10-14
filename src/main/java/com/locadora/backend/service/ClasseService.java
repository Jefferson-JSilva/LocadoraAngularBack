package com.locadora.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.locadora.backend.model.Classe;
import com.locadora.backend.repository.ClasseRepository;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    // Lista todas as classes
    public List<Classe> listar() {
        return classeRepository.findAll();
    }

    // Cadastra uma nova classe
    public Classe cadastrar(Classe classe) {
        return classeRepository.save(classe);
    }

    // Atualiza uma classe existente
    public Classe atualizar(Long id, Classe classe) {

        Classe classeExistente = classeRepository.findById(id).orElse(null);

        if (classeExistente == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Classe não encontrada"
            );
        }

        classeExistente.setNome(classe.getNome());

        return classeRepository.save(classeExistente);
    }

    // Exclui uma classe
    public void excluir(Long id) {

        if (!classeRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Classe não encontrada"
            );
        }

        classeRepository.deleteById(id);
    }
}