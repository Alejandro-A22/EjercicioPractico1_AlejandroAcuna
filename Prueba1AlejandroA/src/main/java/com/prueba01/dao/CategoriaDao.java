package com.prueba01.dao;

import com.prueba01.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
}
