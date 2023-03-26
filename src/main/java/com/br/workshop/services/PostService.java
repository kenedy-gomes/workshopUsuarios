package com.br.workshop.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.workshop.Repository.PostRepository;
import com.br.workshop.domain.Post;
import com.br.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	 private PostRepository repo;

	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	} 
	
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
}
