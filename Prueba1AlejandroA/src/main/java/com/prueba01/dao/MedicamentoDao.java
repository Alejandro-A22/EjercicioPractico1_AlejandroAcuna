/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba01.dao;
import com.prueba01.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoDao extends JpaRepository<Medicamento,Long> {
    
}
