package com.locadora.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.locadora.backend.model.Diretor;
import com.locadora.backend.repository.DiretorRepository;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    // Lista todos os diretores
    public List<Diretor> listar() {
        return diretorRepository.findAll();
    }

    // Cadastra um novo diretor
    public Diretor cadastrar(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    // Atualiza um diretor existente
    public Diretor atualizar(Long id, Diretor diretor) {

        Diretor diretorExistente = diretorRepository.findById(id).orElse(null);

        if (diretorExistente == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Diretor não encontrado"
            );
        }

        diretorExistente.setNome(diretor.getNome());

        return diretorRepository.save(diretorExistente);
    }

    // Exclui um diretor
    public void excluir(Long id) {

        if (!diretorRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Diretor não encontrado"
            );
        }

        diretorRepository.deleteById(id);
    }
}