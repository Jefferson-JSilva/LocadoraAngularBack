package com.locadora.backend.repository;

// oferece métodos prontos para manipular dados no banco
import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.backend.model.Ator;

public interface AtorRepository extends JpaRepository<Ator, Long> {

}