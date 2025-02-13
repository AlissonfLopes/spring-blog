package com.fiap.spring_blog.repository;

import com.fiap.spring_blog.model.Artigo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtigoRepository extends MongoRepository<Artigo, String> {

    public void deleteById(String codigo);
}
