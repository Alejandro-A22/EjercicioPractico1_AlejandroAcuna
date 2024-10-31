package com.prueba01.controller;

import com.prueba01.domain.Cliente;
import com.prueba01.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/cliente/listado"; // Adjust the view path as necessary
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "/cliente/modifica"; // Adjust the view path as necessary
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(@PathVariable("idCliente") Long idCliente) {
        clienteService.delete(idCliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(@PathVariable("idCliente") Long idCliente, Model model) {
        Cliente cliente = clienteService.findById(idCliente)
            .orElseThrow(() -> new RuntimeException("Cliente not found"));
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica"; // Adjust the view path as necessary
    }
}