package com.example.transferencias.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "usuarios")
    @JsonIgnore
    private Tarjetas tarjeta;
    @Column(name = "nombre_usuario" , nullable = false)
    private String nombreUsuario;

    @Column(name = "clave_usuario")
    private String claveUsuario;

}