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
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_cliente"))
    private Cliente cliente;

    @Column(name = "total", nullable = false)
    private Double total;

    public Factura() {
    }

    public Factura(Date fecha, Cliente cliente, Double total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
    }
}
