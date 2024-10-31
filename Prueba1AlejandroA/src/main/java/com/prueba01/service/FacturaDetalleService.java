package com.prueba01.service;

import com.prueba01.domain.FacturaDetalle;
import java.util.List;
import java.util.Optional;

public interface FacturaDetalleService {
    FacturaDetalle save(FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> findById(Long id);
    List<FacturaDetalle> findAll();
    FacturaDetalle update(Long id, FacturaDetalle facturaDetalle);
    void delete(Long id);
}