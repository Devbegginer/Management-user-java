package br.com.portfolioweb.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.portfolioweb.crud.entities.User;
import br.com.portfolioweb.crud.repositories.UserRepository;

// essa e uma classe de configuracao
@Configuration 
//classe e para o perfil de teste
//spring.profiles.active = test
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//atributo
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		userRepository.saveAll(Arrays.asList(u1,u2));
	} 
	 
}
 