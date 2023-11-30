package com.example.transferencias.services;

import com.example.transferencias.entitys.Usuarios;
import com.example.transferencias.repositorys.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuarioService(UsuariosRepository usuariosRepository){
         this.usuariosRepository = usuariosRepository;
    }

    public Usuarios createUsuario(Usuarios usuarios){
        return this.usuariosRepository.save(usuarios);
    }

    public Optional<Usuarios> getUsuario(UUID id){
        return this.usuariosRepository.findById(id);
    }

    public List<Usuarios> getAllUsuarios(){
        return this.usuariosRepository.findAll();
    }

}
