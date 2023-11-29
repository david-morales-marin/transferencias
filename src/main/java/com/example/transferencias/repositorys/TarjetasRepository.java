package com.example.transferencias.repositorys;

import com.example.transferencias.entitys.Tarjetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface TarjetasRepository extends JpaRepository<Tarjetas , UUID> {
}
