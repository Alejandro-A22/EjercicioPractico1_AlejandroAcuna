package com.prueba01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps to the id column in the factura_detalle table
    private Long id; // Primary key

    @ManyToOne // Defines a many-to-one relationship with Factura
    @JoinColumn(name = "id_factura", nullable = false, foreignKey = @ForeignKey(name = "fk_factura")) // Maps to the id_factura column
    private Factura factura; // Reference to the Factura entity

    @ManyToOne // Defines a many-to-one relationship with Medicamento
    @JoinColumn(name = "id_medicamento", nullable = false, foreignKey = @ForeignKey(name = "fk_medicamento")) // Maps to the id_medicamento column
    private Medicamento medicamento; // Reference to the Medicamento entity

    @Column(name = "cantidad", nullable = false) // Maps to the cantidad column
    private Integer cantidad; // Quantity of the medication

    @Column(name = "precio_unitario", nullable = false) // Maps to the precio_unitario column
    private Double precioUnitario; // Unit price of the medication

    @Column(name = "subtotal", insertable = false, updatable = false) // Maps to the subtotal column
    private Double subtotal; // Subtotal, calculated as cantidad * precio_unitario

    public FacturaDetalle() {
    }

    public FacturaDetalle(Factura factura, Medicamento medicamento, Integer cantidad, Double precioUnitario) {
        this.factura = factura;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}