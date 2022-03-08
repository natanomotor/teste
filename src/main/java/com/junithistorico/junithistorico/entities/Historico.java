package com.junithistorico.junithistorico.entities;

import com.junithistorico.junithistorico.enums.HistoricoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Historico {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "historico")
    private Usuario user;
    private String date;
    private HistoricoEnum status;

}
