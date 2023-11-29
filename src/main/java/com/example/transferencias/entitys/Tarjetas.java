package com.example.transferencias.entitys;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tarjetas")
public class Tarjetas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @OneToOne
    @JoinColumn(name = "usuario_id")
    @NonNull
    private Usuarios usuario;


    @Column(name = "saldo_cuenta")
    private double saldoCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    //@Column(name = "numero_cuenta")
    //private UUID numeroCuenta;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "recargar_saldo")
    private double recargarSaldo;
}
