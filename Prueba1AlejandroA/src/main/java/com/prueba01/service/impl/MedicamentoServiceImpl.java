package com.prueba01.service.impl;

import com.prueba01.dao.MedicamentoDao;
import com.prueba01.domain.Medicamento;
import com.prueba01.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    private final MedicamentoDao medicamentoDao;

    @Autowired
    public MedicamentoServiceImpl(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    @Override
    public Medicamento save(Medicamento medicamento) {
        return medicamentoDao.save(medicamento);
    }

    @Override
    public Optional<Medicamento> findById(Long id) {
        return medicamentoDao.findById(id);
    }

    @Override
    public List<Medicamento> findAll() {
        return medicamentoDao.findAll();
    }

    @Override
    public Medicamento update(Long id, Medicamento medicamento) {
        if (medicamentoDao.existsById(id)) {
            medicamento.setId(id); // Set the ID of the existing entity
            return medicamentoDao.save(medicamento);
        }
        return null; // Or throw an exception if not found
    }

    @Override
    public void delete(Long id) {
        if (medicamentoDao.existsById(id)) {
            medicamentoDao.deleteById(id);
        }
        // Optionally throw an exception if not found
    }
}