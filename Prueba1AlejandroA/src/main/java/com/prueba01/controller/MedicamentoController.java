package com.prueba01.controller;

import com.prueba01.domain.Medicamento;
import com.prueba01.service.MedicamentoService;
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
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Medicamento> medicamentos = medicamentoService.findAll();
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("totalMedicamentos", medicamentos.size());
        return "/medicamento/listado";
    }

    @GetMapping("/nuevo")
    public String medicamentoNuevo(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        return "/medicamento/modifica";
    }

    @PostMapping("/guardar")
    public String medicamentoGuardar(Medicamento medicamento) {
        medicamentoService.save(medicamento);
        return "redirect:/medicamento/listado";
    }

    @GetMapping("/eliminar/{idMedicamento}")
    public String medicamentoEliminar(@PathVariable("idMedicamento") Long idMedicamento) {
        medicamentoService.delete(idMedicamento);
        return "redirect:/medicamento/listado";
    }

    @GetMapping("/modificar/{idMedicamento}")
    public String medicamentoModificar(@PathVariable("idMedicamento") Long idMedicamento, Model model) {
        Medicamento medicamento = medicamentoService.findById(idMedicamento)
                .orElseThrow(() -> new RuntimeException("Medicamento not found"));
        model.addAttribute("medicamento", medicamento);
        return "/medicamento/modifica";
    }
}
