package com.prueba01.service.impl;

import com.prueba01.dao.ClienteDao;
import com.prueba01.domain.Cliente;
import com.prueba01.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteDao clienteDao;

    @Autowired
    public ClienteServiceImpl(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteDao.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        if (clienteDao.existsById(id)) {
            cliente.setId(id);
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (clienteDao.existsById(id)) {
            clienteDao.deleteById(id);
        }

    }
}
