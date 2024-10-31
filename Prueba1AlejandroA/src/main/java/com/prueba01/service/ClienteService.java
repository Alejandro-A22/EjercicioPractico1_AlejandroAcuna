package com.prueba01.service;

import com.prueba01.domain.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    Cliente update(Long id, Cliente cliente);

    void delete(Long id);
}
