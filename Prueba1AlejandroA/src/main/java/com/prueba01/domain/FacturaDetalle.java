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
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false, foreignKey = @ForeignKey(name = "fk_factura"))
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_medicamento", nullable = false, foreignKey = @ForeignKey(name = "fk_medicamento"))
    private Medicamento medicamento;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "subtotal", insertable = false, updatable = false)
    private Double subtotal;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Factura factura, Medicamento medicamento, Integer cantidad, Double precioUnitario) {
        this.factura = factura;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
