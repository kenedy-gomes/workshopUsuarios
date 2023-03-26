package com.br.workshop.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

 
}