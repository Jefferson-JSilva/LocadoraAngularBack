package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Diretor;
import com.locadora.backend.repository.DiretorRepository;

@RestController
@RequestMapping("/diretores")
@CrossOrigin(origins = "http://localhost:4200")
public class DiretorController {
    // faz o Spring fornecer automaticamente uma instância do Repository para o Controller.
    @Autowired
    private DiretorRepository diretorRepository;

    // Lista todos os diretores
    @GetMapping
    public List<Diretor> listar() {
        return diretorRepository.findAll();
    }

    // Cadastra um novo diretor
    @PostMapping
    public Diretor cadastrar(@RequestBody Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    // Atualiza um diretor existente
    @PutMapping("/{id}")
    public Diretor atualizar(@PathVariable Long id, @RequestBody Diretor diretor) {

        Diretor diretorExistente = diretorRepository.findById(id).orElse(null);

        if (diretorExistente == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Diretor não encontrado"
            );
        }

        diretorExistente.setNome(diretor.getNome());

        return diretorRepository.save(diretorExistente);
    }

    // Exclui um diretor
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        if (!diretorRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Diretor não encontrado"
            );
        }

        diretorRepository.deleteById(id);
    }
}