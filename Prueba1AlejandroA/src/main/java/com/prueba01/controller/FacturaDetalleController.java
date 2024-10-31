package com.prueba01.controller;

import com.prueba01.domain.FacturaDetalle;
import com.prueba01.service.FacturaDetalleService;
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
@RequestMapping("/facturaDetalle")
public class FacturaDetalleController {

    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<FacturaDetalle> facturaDetalles = facturaDetalleService.findAll();
        model.addAttribute("facturaDetalles", facturaDetalles);
        model.addAttribute("totalFacturaDetalles", facturaDetalles.size());
        return "/facturaDetalle/listado";
    }

    @GetMapping("/nuevo")
    public String facturaDetalleNuevo(Model model) {
        model.addAttribute("facturaDetalle", new FacturaDetalle());
        return "/facturaDetalle/modifica";
    }

    @PostMapping("/guardar")
    public String facturaDetalleGuardar(FacturaDetalle facturaDetalle) {
        facturaDetalleService.save(facturaDetalle);
        return "redirect:/facturaDetalle/listado";
    }

    @GetMapping("/eliminar/{idFacturaDetalle}")
    public String facturaDetalleEliminar(@PathVariable("idFacturaDetalle") Long idFacturaDetalle) {
        facturaDetalleService.delete(idFacturaDetalle);
        return "redirect:/facturaDetalle/listado";
    }

    @GetMapping("/modificar/{idFacturaDetalle}")
    public String facturaDetalleModificar(@PathVariable("idFacturaDetalle") Long idFacturaDetalle, Model model) {
        FacturaDetalle facturaDetalle = facturaDetalleService.findById(idFacturaDetalle)
                .orElseThrow(() -> new RuntimeException("FacturaDetalle not found"));
        model.addAttribute("facturaDetalle", facturaDetalle);
        return "/facturaDetalle/modifica";
    }
}
