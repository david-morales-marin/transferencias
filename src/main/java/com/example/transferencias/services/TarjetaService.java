package com.example.transferencias.services;

import com.example.transferencias.entitys.Tarjetas;
import com.example.transferencias.repositorys.TarjetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarjetaService {

    @Autowired
    private TarjetasRepository tarjetasRepository;

    public TarjetaService (TarjetasRepository tarjetasRepository){

        this.tarjetasRepository = tarjetasRepository;
    }

    public Tarjetas createTargeta(UUID  usuario_id, Tarjetas tarjetas){
        return this.tarjetasRepository.save(tarjetas);
    }

    public Optional<Tarjetas> getTargeta(UUID id){
        return this.tarjetasRepository.findById(id);
    }

    public List<Tarjetas> getAllTarjetas(){
        return this.tarjetasRepository.findAll();
    }

    public Tarjetas transferenciasTarjetas(Tarjetas tarjetas, UUID id){

        Tarjetas tarjetas1 = tarjetasRepository.findById(id).get();
        tarjetas1.setSaldoCuenta(tarjetas1.getSaldoCuenta());
        this.tarjetasRepository.save(tarjetas1);

        Tarjetas tarjetas2 = tarjetasRepository.findById(id).get();
        tarjetas2.setSaldoCuenta(tarjetas2.getSaldoCuenta());
        this.tarjetasRepository.save(tarjetas2);

        return this.tarjetasRepository.save(tarjetas);

    }

    public Tarjetas recargarTarjeta(Tarjetas tarjetas1, UUID id){

        tarjetas1 = tarjetasRepository.findById(id).get();
        tarjetas1.setRecargarSaldo(tarjetas1.getRecargarSaldo());

        return this.tarjetasRepository.save(tarjetas1);

    }

}
