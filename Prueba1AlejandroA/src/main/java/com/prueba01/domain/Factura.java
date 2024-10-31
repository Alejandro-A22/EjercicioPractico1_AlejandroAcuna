package com.prueba01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps to the id column in the facturas table
    private Long id; // Primary key

    @Column(name = "fecha", nullable = false) // Maps to the fecha column
    @Temporal(TemporalType.DATE) // Specifies that the date should be treated as a date
    private Date fecha; // Date of the invoice

    @ManyToOne // Defines a many-to-one relationship with Cliente
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_cliente")) // Maps to the id_cliente column
    private Cliente cliente; // Reference to the Cliente entity

    @Column(name = "total", nullable = false) // Maps to the total column
    private Double total; // Total amount of the invoice

    public Factura() {
    }

    public Factura(Date fecha, Cliente cliente, Double total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
    }
}