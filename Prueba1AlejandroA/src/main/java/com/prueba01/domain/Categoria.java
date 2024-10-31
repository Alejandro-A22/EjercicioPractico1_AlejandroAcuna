package com.prueba01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Updated to match the new table definition
    private Long id; // Updated to match the new table definition

    @Column(name = "nombre", nullable = false) // Updated to match the new table definition
    private String nombre; // Updated to match the new table definition

    @Column(name = "descripcion") // Updated to match the new table definition
    private String descripcion; // Kept as is

    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) { // Updated constructor to match new fields
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
