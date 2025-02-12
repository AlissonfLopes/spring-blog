package com.fiap.spring_blog.service.impl;

import com.fiap.spring_blog.model.Autor;
import com.fiap.spring_blog.repository.AutorRepository;
import com.fiap.spring_blog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceimpl implements AutorService {

    private MongoTemplate mongoTemplate;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutores() {
        return this.autorRepository.findAll();
    }

    public AutorServiceimpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Autor listarAutorPorId(String codigoAutor) {
        return this.autorRepository
                .findById(codigoAutor)
                .orElseThrow(()-> new IllegalArgumentException("Autor não existe"));
    }

    @Override
    public Autor salvarAutor(Autor autor) {
        return this.autorRepository.save(autor);
    }

    public List<Autor> listarAutorPorNome(String nome) {
        Query query = new Query(Criteria.where("nome").is(nome));
        return mongoTemplate.find(query, Autor.class);
    }

}
