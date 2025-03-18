package com.fiap.spring_blog.service.impl;

import com.fiap.spring_blog.model.Artigo;
import com.fiap.spring_blog.model.Autor;
import com.fiap.spring_blog.repository.ArtigoRepository;
import com.fiap.spring_blog.repository.AutorRepository;
import com.fiap.spring_blog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    private MongoTemplate mongoTemplate;

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    public ArtigoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Artigo> obterTodos() {
        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Artigo não existe"));
    }

    @Override
    public Artigo criarArtigo(Artigo artigo) {

        if(artigo.getAutor().getCodigo() != null) {
            Autor autor = this.autorRepository
                    .findById(artigo.getAutor().getCodigo())
                    .orElseThrow(()-> new IllegalArgumentException("Autor inexistente"));

            artigo.setAutor(autor);
        } else {
            artigo.setAutor(null);
        }
        return this.artigoRepository.save(artigo);
    }

    @Override
    public List<Artigo> findByDataGreaterThan(LocalDateTime data) {
        Query query = new Query(Criteria.where("data").gt(data));
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status) {
        Query query = new Query (Criteria.where("data").is(data)
                .and("status").is(status));
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public void atualizarArtigo(Artigo updateArtigo) {
        this.artigoRepository.save(updateArtigo);
    }

    @Override
    public void atualizarArtigoURL(String codigo, String URL) {
        Query query = new Query(Criteria.where("codigo").is(codigo));
        Update update = new Update().set("url", URL);
        this.mongoTemplate.updateFirst(query, update, Artigo.class);
    }

    @Override
    public void deleteById(String codigo){
        this.artigoRepository.deleteById(codigo);
    }

    @Override
    public void deleteArtigoById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        this.mongoTemplate.remove(query, Artigo.class);
    }

    @Override
    public List<Artigo> findByStatusAndData (Integer status, LocalDateTime data) {
        return this.artigoRepository.findByStatusAndData(status, data);
    }

    @Override
    public List<Artigo> findByStatusEquals(Integer status) {
        return this.artigoRepository.findByStatusEquals(status);
    }

    @Override
    public List<Artigo> findByDateAndHour(LocalDateTime date, LocalDateTime hour) {
        return this.artigoRepository.findByDateAndHour(date, hour);
    }

    @Override
    public List<Artigo> findComplexArticles(Integer status,
                                            LocalDateTime data,
                                            String titulo) {
        // The ideia here is create a filter with date less or igual
        // than the given value
        Criteria criteria = new Criteria();
        criteria.and("data").lte(data);

        // We need a valid status
        if (status != null) {
            criteria.and("Status").is(status);
        }

        // We need a valid title
        if (titulo != null && !titulo.isEmpty()) {
            criteria.and("titulo").regex(titulo, "i");
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public Page<Artigo> findAll(Pageable pageable) {
        return this.artigoRepository.findAll(pageable);
    }

    @Override
    public List<Artigo> findByStatusOrderByTituloAsc(Integer status) {
        return this.artigoRepository.findByStatusOrderByTituloAsc(status);
    }

    @Override
    public List<Artigo> findByStatusAsc(Integer status) {
        return this.artigoRepository.findByStatusAsc(status);
    }
}
