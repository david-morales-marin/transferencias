package com.example.transferencias.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Tarjetas tarjeta;

    @Column(name = "nombre_usuario" , nullable = false)
    private String nombreUsuario;

    @Column(name = "clave_usuario")
    private String claveUsuario;

}
