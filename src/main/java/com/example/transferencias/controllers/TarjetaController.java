package com.example.transferencias.controllers;

import com.example.transferencias.entitys.Tarjetas;
import com.example.transferencias.entitys.Usuarios;
import com.example.transferencias.services.TarjetaService;
import com.example.transferencias.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private TarjetaController(TarjetaService tarjetaService){
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/")
    public List<Tarjetas> getTarjetas(){
        return this.tarjetaService.getAllTarjetas();
    }

    @GetMapping("/{id}")
    public Optional<Tarjetas> getTarjetaById(@PathVariable("id") UUID id){
        return  this.tarjetaService.getTargeta(id);
    }

    @PostMapping("usuario/{usuario_id}/tarjeta")
    public ResponseEntity<Tarjetas> createTarjeta(@PathVariable UUID usuario_id, @RequestBody Tarjetas tarjetas){

        if (tarjetas.getUsuario() == null || tarjetas.getUsuario().equals(0) ||
           tarjetas.getNumeroCuenta() == null || tarjetas.getNumeroCuenta() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {

            Tarjetas createTarjeta = tarjetaService.createTargeta(usuario_id, tarjetas);
            return ResponseEntity.status(HttpStatus.CREATED).body(createTarjeta);

        }
    }

    @PostMapping("transferencia/{tarjeta1}/{tarjeta2}")
    public ResponseEntity<Tarjetas> transferir(@PathVariable UUID id1, @RequestBody Tarjetas tarjetas1 ,
                                               @PathVariable UUID id2 , @RequestBody Tarjetas tarjetas2){

        if(tarjetas1.getSaldoCuenta() <= 0 ||
            tarjetas1.getTransferir() > tarjetas1.getSaldoCuenta() ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{

            tarjetas1.setSaldoCuenta(tarjetas1.getSaldoCuenta() - tarjetas1.getTransferir());
            tarjetas2.setSaldoCuenta(tarjetas2.getSaldoCuenta() + tarjetas1.getTransferir());

            Tarjetas saldoTotal1 = tarjetaService.transferenciasTarjetas(tarjetas1, id1);
            Tarjetas saldoTotal2 = tarjetaService.transferenciasTarjetas(tarjetas2 , id2);
            ResponseEntity.status(HttpStatus.CREATED).body(saldoTotal2);
            return ResponseEntity.status(HttpStatus.CREATED).body(saldoTotal1);
        }

    }

    @PostMapping("recarga/{id}")
    public ResponseEntity<Tarjetas> recargarTarjeta(@PathVariable UUID id, @RequestBody Tarjetas tarjetas){

        if( tarjetas.getNumeroCuenta() == null || tarjetas.getNumeroCuenta() <= 0 ||
                tarjetas.getRecargarSaldo() <= 0  ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {

            tarjetas.setRecargarSaldo(tarjetas.getRecargarSaldo());
            tarjetas.setSaldoCuenta(tarjetas.getSaldoCuenta() + tarjetas.getRecargarSaldo());

            Tarjetas recargaTarjeta = tarjetaService.recargarTarjeta(tarjetas , id);
            return ResponseEntity.status(HttpStatus.CREATED).body(recargaTarjeta);
         }

        }



}
