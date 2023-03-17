package com.br.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.workshop.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResorce {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User kenedy = new User("2", "kenedy gomes", "kndgfls5@gmail.com");
		User maria = new User("1", "Maria", "maria5@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(kenedy, maria));
		return ResponseEntity.ok().body(list);
	}
	
}
