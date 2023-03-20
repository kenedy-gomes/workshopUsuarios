package com.br.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.workshop.DTO.UserDTO;
import com.br.workshop.Repository.UserRepository;
import com.br.workshop.domain.User;
import com.br.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	} 
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Optional<User> newObj, User obj) {
		newObj.orElseThrow().setName(obj.getName());
		newObj.orElseThrow().setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
		
	}
	
}
