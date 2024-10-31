package com.prueba01.controller;

import com.prueba01.domain.Factura;
import com.prueba01.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Factura> facturas = facturaService.findAll();
        model.addAttribute("facturas", facturas);
        model.addAttribute("totalFacturas", facturas.size());
        return "/factura/listado";
    }

    @GetMapping("/nuevo")
    public String facturaNuevo(Model model) {
        model.addAttribute("factura", new Factura());
        return "/factura/modifica";
    }

    @PostMapping("/guardar")
    public String facturaGuardar(Factura factura) {
        facturaService.save(factura);
        return "redirect:/factura/listado";
    }

    @GetMapping("/eliminar/{idFactura}")
    public String facturaEliminar(@PathVariable("idFactura") Long idFactura) {
        facturaService.delete(idFactura);
        return "redirect:/factura/listado";
    }

    @GetMapping("/modificar/{idFactura}")
    public String facturaModificar(@PathVariable("idFactura") Long idFactura, Model model) {
        Factura factura = facturaService.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura not found"));
        model.addAttribute("factura", factura);
        return "/factura/modifica";
    }
}
