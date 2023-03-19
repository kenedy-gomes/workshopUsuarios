package com.br.workshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.workshop.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

}