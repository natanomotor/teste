package com.junithistorico.junithistorico;

import com.junithistorico.junithistorico.entities.Usuario;
import com.junithistorico.junithistorico.functions.UsuarioLogin;
import com.junithistorico.junithistorico.repositories.HistoricoRepository;
import com.junithistorico.junithistorico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunithistoricoApplication implements CommandLineRunner {
	@Autowired
	public UsuarioRepository usuarioRepository = new UsuarioRepository();
	@Autowired
	public HistoricoRepository historicoRepository = new HistoricoRepository();

	public static void main(String[] args) {
		SpringApplication.run(JunithistoricoApplication.class, args);
	}
	public void run(String...args){

		Usuario user1 = new Usuario("natan1@omotor.com.br","123456");
		Usuario user2 = new Usuario("rafael@omotor.com.br","123456");
		Usuario user3 = new Usuario("joao@omotor.com.br","123456");
		Usuario user4 = new Usuario("alefe@omotor.com.br","123456");

		Usuario user10 = new Usuario("natan123@omotor.com.br","123456");
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		usuarioRepository.save(user3);
		usuarioRepository.save(user4);
		System.out.println(usuarioRepository.findByEmail("natan@omotor.com.br"));
		UsuarioLogin ul = new UsuarioLogin(usuarioRepository,historicoRepository);
		ul.logar(user10);
	}

}
