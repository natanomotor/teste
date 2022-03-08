package com.junithistorico.junithistorico.resource;

import com.junithistorico.junithistorico.entities.Historico;
import com.junithistorico.junithistorico.entities.Usuario;
import com.junithistorico.junithistorico.repositories.HistoricoRepository;
import com.junithistorico.junithistorico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/historico")
public class HistoricoResource {
    @Autowired
    private HistoricoRepository historicoRepository;
    @GetMapping
    public ResponseEntity<List<Historico>> findAll(){
        List <Historico> list = historicoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{email}")
    public ResponseEntity<Historico> findByEmail(@PathVariable String email){
        Historico user = historicoRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
