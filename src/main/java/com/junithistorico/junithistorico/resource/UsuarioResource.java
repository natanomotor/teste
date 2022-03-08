package com.junithistorico.junithistorico.resource;

import com.junithistorico.junithistorico.entities.Usuario;
import com.junithistorico.junithistorico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List <Usuario> list = usuarioRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
        Usuario user = usuarioRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
    //@PostMapping
    //@PutMapping
    //@DeleteMapping
}
