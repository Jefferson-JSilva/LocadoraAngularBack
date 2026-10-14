package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Classe;
import com.locadora.backend.repository.ClasseRepository;

@RestController
@RequestMapping("/classes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClasseController {
    // faz o Spring fornecer automaticamente uma instância do Repository para o Controller.
    @Autowired
    private ClasseRepository classeRepository;

    // Lista todas as classes
    @GetMapping
    public List<Classe> listar() {
        return classeRepository.findAll();
    }

    // Cadastra uma nova classe
    @PostMapping
    public Classe cadastrar(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }

    // Atualiza uma classe existente
    @PutMapping("/{id}")
    public Classe atualizar(@PathVariable Long id, @RequestBody Classe classe) {

        Classe classeExistente = classeRepository.findById(id).orElse(null);

        if (classeExistente == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Classe não encontrada"
            );
        }

        classeExistente.setNome(classe.getNome());

        return classeRepository.save(classeExistente);
    }

    // Exclui uma classe
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        if (!classeRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Classe não encontrada"
            );
        }

        classeRepository.deleteById(id);
    }
}