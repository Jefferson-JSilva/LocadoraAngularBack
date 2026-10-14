package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Ator;
import com.locadora.backend.repository.AtorRepository;

@RestController
@RequestMapping("/atores")
@CrossOrigin(origins = "http://localhost:4200")
public class AtorController {
    // faz o Spring fornecer automaticamente uma instância do Repository para o Controller.
    @Autowired
    private AtorRepository atorRepository;

    // Lista todos os atores
    @GetMapping
    public List<Ator> listar() {
        return atorRepository.findAll();
    }

    // Cadastra um novo ator
    @PostMapping
    public Ator cadastrar(@RequestBody Ator ator) {
        return atorRepository.save(ator);
    }

    // Atualiza um ator existente
    @PutMapping("/{id}")
    public Ator atualizar(@PathVariable Long id, @RequestBody Ator ator) {

        Ator atorExistente = atorRepository.findById(id).orElse(null);

        if (atorExistente == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Ator não encontrado"
            );
        }

        atorExistente.setNome(ator.getNome());

        return atorRepository.save(atorExistente);
    }

    // Exclui um ator
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        if (!atorRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Ator não encontrado"
            );
        }

        atorRepository.deleteById(id);
    }
}