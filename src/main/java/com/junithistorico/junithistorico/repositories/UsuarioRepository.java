package com.junithistorico.junithistorico.repositories;

import com.junithistorico.junithistorico.entities.Historico;
import com.junithistorico.junithistorico.entities.Usuario;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioRepository {
    private Map<String, Usuario> map = new HashMap<>();

    public void save(Usuario obj){
        map.put(obj.getLogin(), obj);
    }

    public Usuario findByEmail(String email){
        return map.get(email);
    }

    public List<Usuario> findAll(){
       return new ArrayList<Usuario>(map.values());
    }
}
