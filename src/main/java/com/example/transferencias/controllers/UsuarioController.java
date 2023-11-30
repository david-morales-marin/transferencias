package com.example.transferencias.controllers;

import com.example.transferencias.entitys.Usuarios;
import com.example.transferencias.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public List<Usuarios> getUsuarios(){
        return this.usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> getUsuarioById(@PathVariable("id") UUID id){
        return this.usuarioService.getUsuario(id);
    }

    @PostMapping()
    public ResponseEntity<String> createUsuario(@RequestBody Usuarios usuarios){

        if(usuarios.getNombreUsuario() == "" || usuarios.getNombreUsuario().isEmpty() ||
           usuarios.getClaveUsuario() == "" || usuarios.getClaveUsuario().isEmpty()){
            return new ResponseEntity<>("El nombre y/o la clave para la creacion del usuario es obligatorio " , HttpStatus.BAD_REQUEST);
        }

        this.usuarioService.createUsuario(usuarios);
        return new ResponseEntity<>("Usuario creado con exito ", HttpStatus.CREATED);

    }

}
