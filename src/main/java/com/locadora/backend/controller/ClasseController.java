package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Classe;
import com.locadora.backend.service.ClasseService;

@RestController
@RequestMapping("/classes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> listar() {
        return classeService.listar();
    }

    @PostMapping
    public Classe cadastrar(@RequestBody Classe classe) {
        return classeService.cadastrar(classe);
    }

    @PutMapping("/{id}")
    public Classe atualizar(@PathVariable Long id, @RequestBody Classe classe) {
        return classeService.atualizar(id, classe);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        classeService.excluir(id);
    }
}
