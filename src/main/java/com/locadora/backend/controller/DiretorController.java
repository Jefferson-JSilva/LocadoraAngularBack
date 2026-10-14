package com.locadora.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.locadora.backend.model.Diretor;
import com.locadora.backend.service.DiretorService;

@RestController
@RequestMapping("/diretores")
@CrossOrigin(origins = "http://localhost:4200")
public class DiretorController {
    @Autowired
    private DiretorService diretorService;

    @GetMapping
    public List<Diretor> listar() {
        return diretorService.listar();
    }

    @PostMapping
    public Diretor cadastrar(@RequestBody Diretor diretor) {
        return diretorService.cadastrar(diretor);
    }

    @PutMapping("/{id}")
    public Diretor atualizar(@PathVariable Long id, @RequestBody Diretor diretor) {
        return diretorService.atualizar(id, diretor);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        diretorService.excluir(id);
    }
}
