package com.prueba01.service;

import com.prueba01.domain.Factura;
import java.util.List;
import java.util.Optional;

public interface FacturaService {

    Factura save(Factura factura);

    Optional<Factura> findById(Long id);

    List<Factura> findAll();

    Factura update(Long id, Factura factura);

    void delete(Long id);
}
