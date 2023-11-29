package com.example.transferencias.repositorys;

import com.example.transferencias.entitys.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios , UID> {
}
