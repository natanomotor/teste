package com.junithistorico.junithistorico.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    public Usuario (String l, String s){
        login =l;
        senha = s;
    }
    private Long id;

    private String login;

    private String senha;
    @OneToMany (mappedBy = "user")
    private List<Historico> historico;

}
