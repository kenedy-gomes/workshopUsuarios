package com.br.workshop.config;

 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.workshop.DTO.AuthorDTO;
import com.br.workshop.DTO.CommentsDTO;
import com.br.workshop.Repository.PostRepository;
import com.br.workshop.Repository.UserRepository;
import com.br.workshop.domain.Post;
import com.br.workshop.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
 
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User joao = new User(null, "joao Brown", "joao@gmail.com");
		User kenedy = new User(null, "Kenedy Gomes", "kndgfls5@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, joao, kenedy));
		
		Post post1 = new Post(null, "Viagem a são paulo", sdf.parse("20/03/2018"), "Cidade linda!", new AuthorDTO(maria));
		Post post2 = new Post(null, "Inglaterra é muito linda", sdf.parse("05/01/2023"), "Inglaterra é uma obra prima!",new AuthorDTO(joao));
		Post post3 = new Post(null, "cineminha hj com a gata", sdf.parse("10/11/2022"), "com a gata @saraKelly!", new AuthorDTO(kenedy));
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		CommentsDTO c1 = new CommentsDTO("Boa viagem, meu irmão!", sdf.parse("21/02/2019"), new AuthorDTO(maria));
		CommentsDTO c2 = new CommentsDTO("Até logo, parceiro", sdf.parse("22/12/2017"), new AuthorDTO(joao));
		CommentsDTO c3 = new CommentsDTO("Trás um presente", sdf.parse("19/04/2023"), new AuthorDTO(kenedy));
		
		post1.getComments().addAll(Arrays.asList(c3, c2));
		post2.getComments().addAll(Arrays.asList(c1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	
	}

}
 