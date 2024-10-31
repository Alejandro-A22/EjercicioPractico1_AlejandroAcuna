package prueba01.service.impl;

import com.prueba01.dao.FacturaDao;
import com.prueba01.domain.Factura;
import com.prueba01.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaDao facturaDao;

    @Autowired
    public FacturaServiceImpl(FacturaDao facturaDao) {
        this.facturaDao = facturaDao;
    }

    @Override
    public Factura save(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return facturaDao.findById(id);
    }

    @Override
    public List<Factura> findAll() {
        return facturaDao.findAll();
    }

    @Override
    public Factura update(Long id, Factura factura) {
        if (facturaDao.existsById(id)) {
            factura.setId(id); // Set the ID of the existing entity
            return facturaDao.save(factura);
        }
        return null; // Or throw an exception if not found
    }

    @Override
    public void delete(Long id) {
        if (facturaDao.existsById(id)) {
            facturaDao.deleteById(id);
        }
        // Optionally throw an exception if not found
    }
}