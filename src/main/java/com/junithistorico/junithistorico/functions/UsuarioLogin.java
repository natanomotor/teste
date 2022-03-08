package com.junithistorico.junithistorico.functions;

import com.junithistorico.junithistorico.entities.Historico;
import com.junithistorico.junithistorico.entities.Usuario;
import com.junithistorico.junithistorico.enums.HistoricoEnum;
import com.junithistorico.junithistorico.repositories.HistoricoRepository;
import com.junithistorico.junithistorico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping (value ="/login")
public class UsuarioLogin {
    private UsuarioRepository usuarioRepository;
    private HistoricoRepository historicoRepository;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();
    public UsuarioLogin(UsuarioRepository obj, HistoricoRepository obj_historico){
        usuarioRepository = obj;
        historicoRepository = obj_historico;
    }

    public boolean logar(Usuario user){
        try {
            if (!usuarioRepository.findByEmail(user.getLogin()).equals(null)) {
                System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
                System.out.println(usuarioRepository.findByEmail("natan@omotor.com.br").getSenha());

                if(usuarioRepository.findByEmail("natan@omotor.com.br").getSenha().equals("123456")){

                    System.out.println("senha correto");

                    return true;

                }else{

                    System.out.println("senha incorreto");

                    return false;

                }
            }
        }catch(Exception e) {
            Historico historico = new Historico();
            historico.setUser(user);
            historico.setDate(dateTimeFormatter.format(LocalDateTime.now()));
            historico.setStatus(HistoricoEnum.EMAILFAILLED);
            historicoRepository.save(historico);
            System.out.println(e);
            return false;
        }

        return false;
    }
    public boolean deslogar(Usuario user){
        return false;
    }

}
