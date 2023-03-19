package com.br.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.workshop.Repository.UserRepository;
import com.br.workshop.domain.User;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
}
