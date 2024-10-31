package com.prueba01.service;

import com.prueba01.domain.Medicamento;
import java.util.List;
import java.util.Optional;

public interface MedicamentoService {

    Medicamento save(Medicamento medicamento);

    Optional<Medicamento> findById(Long id);

    List<Medicamento> findAll();

    Medicamento update(Long id, Medicamento medicamento);

    void delete(Long id);
}
