package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Ator;
import com.locadora.backend.service.AtorService;

@RestController
@RequestMapping("/atores")
@CrossOrigin(origins = "http://localhost:4200")
public class AtorController {
    @Autowired
    private AtorService atorService;

    @GetMapping
    public List<Ator> listar() {
        return atorService.listar();
    }

    @PostMapping
    public Ator cadastrar(@RequestBody Ator ator) {
        return atorService.cadastrar(ator);
    }

    @PutMapping("/{id}")
    public Ator atualizar(@PathVariable Long id, @RequestBody Ator ator) {
        return atorService.atualizar(id, ator);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        atorService.excluir(id);
    }
}
