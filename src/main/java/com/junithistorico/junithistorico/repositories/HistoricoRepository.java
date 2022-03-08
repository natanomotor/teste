package com.junithistorico.junithistorico.repositories;

import com.junithistorico.junithistorico.entities.Historico;
import com.junithistorico.junithistorico.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HistoricoRepository {
    private Map<Usuario, Historico> map = new HashMap<>();
    public void save(Historico obj){
        map.put(obj.getUser(), obj);
    }

    public Historico findByEmail(String email){
        return map.get(email);
    }

    public List<Historico> findAll(){
        return new ArrayList<Historico>(map.values());
    }

}
