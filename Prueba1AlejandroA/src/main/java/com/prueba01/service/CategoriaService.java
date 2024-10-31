package com.prueba01.service;

import com.prueba01.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    Optional<Categoria> findById(Long id);
    List<Categoria> findAll();
    Categoria update(Long id, Categoria categoria);
    void delete(Long id);
}