package com.prueba01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Maps to the id column in the clientes table
    private Long id; // Primary key

    @Column(name = "nombre", nullable = false) // Maps to the nombre column
    private String nombre; // Client's first name

    @Column(name = "apellido") // Maps to the apellido column
    private String apellido; // Client's last name

    @Column(name = "telefono") // Maps to the telefono column
    private String telefono; // Client's phone number

    @Column(name = "email") // Maps to the email column
    private String email; // Client's email address

    @Column(name = "direccion") // Maps to the direccion column
    private String direccion; // Client's address

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }
}