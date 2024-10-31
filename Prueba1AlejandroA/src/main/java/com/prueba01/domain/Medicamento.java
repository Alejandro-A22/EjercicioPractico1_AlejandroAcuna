package com.prueba01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps to the id column in the medicamentos table
    private Long id; // Primary key

    @Column(name = "nombre", nullable = false) // Maps to the nombre column
    private String nombre; // Name of the medication

    @Column(name = "descripcion") // Maps to the descripcion column
    private String descripcion; // Description of the medication

    @Column(name = "precio", nullable = false) // Maps to the precio column
    private Double precio; // Price of the medication

    @Column(name = "stock", columnDefinition = "int default 0") // Maps to the stock column
    private Integer stock = 0; // Stock of the medication, default is 0

    @ManyToOne // Defines a many-to-one relationship with Categoria
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "fk_categoria")) // Maps to the id_categoria column
    private Categoria categoria; // Reference to the Categoria entity

    public Medicamento() {
    }

    public Medicamento(String nombre, String descripcion, Double precio, Integer stock, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
}