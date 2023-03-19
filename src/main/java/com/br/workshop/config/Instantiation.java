package com.br.workshop.config;

 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.workshop.Repository.UserRepository;
import com.br.workshop.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired 
	private UserRepository userRepoistory;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepoistory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User joao = new User(null, "joao Brown", "joao@gmail.com");
		User pedro = new User(null, "pedro Brown", "pedro@gmail.com");
		
		userRepoistory.saveAll(Arrays.asList(maria, joao, pedro));
	}

}
 