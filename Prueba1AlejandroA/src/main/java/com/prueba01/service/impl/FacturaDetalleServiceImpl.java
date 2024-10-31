package com.prueba01.service.impl;

import com.prueba01.dao.FacturaDetalleDao;
import com.prueba01.domain.FacturaDetalle;
import com.prueba01.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    private final FacturaDetalleDao facturaDetalleDao;

    @Autowired
    public FacturaDetalleServiceImpl(FacturaDetalleDao facturaDetalleDao) {
        this.facturaDetalleDao = facturaDetalleDao;
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        return facturaDetalleDao.save(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> findById(Long id) {
        return facturaDetalleDao.findById(id);
    }

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleDao.findAll();
    }

    @Override
    public FacturaDetalle update(Long id, FacturaDetalle facturaDetalle) {
        if (facturaDetalleDao.existsById(id)) {
            facturaDetalle.setId(id);
            return facturaDetalleDao.save(facturaDetalle);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (facturaDetalleDao.existsById(id)) {
            facturaDetalleDao.deleteById(id);
        }

    }
}
