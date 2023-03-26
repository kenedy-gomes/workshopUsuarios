package com.br.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.workshop.domain.Post;
import com.br.workshop.services.PostService;


@RestController
@RequestMapping(value = "/posts")
public class PostResorce {

	@Autowired
	private PostService service;
		
	 @GetMapping
	public ResponseEntity<List<Post>> findAll() {
		 List<Post> list = service.findAll();
		 return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		 return ResponseEntity.ok().body(obj);
	}
}
