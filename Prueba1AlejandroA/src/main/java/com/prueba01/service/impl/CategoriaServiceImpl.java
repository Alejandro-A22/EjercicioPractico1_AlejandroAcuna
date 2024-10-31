package com.prueba01.service.impl;

import com.prueba01.dao.CategoriaDao;
import com.prueba01.domain.Categoria;
import com.prueba01.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaDao categoriaDao;

    @Autowired
    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaDao.findById(id);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        if (categoriaDao.existsById(id)) {
            categoria.setId(id); // Set the ID of the existing entity
            return categoriaDao.save(categoria);
        }
        return null; // Or throw an exception if not found
    }

    @Override
    public void delete(Long id) {
        if (categoriaDao.existsById(id)) {
            categoriaDao.deleteById(id);
        }
        // Optionally throw an exception if not found
    }
}