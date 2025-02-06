package com.fiap.spring_blog.repository;

import com.fiap.spring_blog.model.Artigo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends MongoRepository<Artigo, String> {

}
