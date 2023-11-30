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

    @Column(name = "numero_cuenta")
    private Long numeroCuenta;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "recargar_saldo")
    private double recargarSaldo;

    @Column(name = "transferir")
    private double transferir;

    public Tarjetas() {
    }

    public Tarjetas(UUID id, @NonNull Usuarios usuario, double saldoCuenta, String tipoCuenta, Long numeroCuenta, Date fechaVencimiento, double recargarSaldo, double transferir) {
        this.id = id;
        this.usuario = usuario;
        this.saldoCuenta = saldoCuenta;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.fechaVencimiento = fechaVencimiento;
        this.recargarSaldo = recargarSaldo;
        this.transferir = transferir;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(@NonNull Usuarios usuario) {
        this.usuario = usuario;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getRecargarSaldo() {
        return recargarSaldo;
    }

    public void setRecargarSaldo(double recargarSaldo) {
        this.recargarSaldo = recargarSaldo;
    }

    public double getTransferir() {
        return transferir;
    }

    public void setTransferir(double transferir) {
        this.transferir = transferir;
    }
}
