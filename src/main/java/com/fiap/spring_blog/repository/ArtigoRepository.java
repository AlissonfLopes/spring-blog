package com.fiap.spring_blog.repository;

import com.fiap.spring_blog.model.Artigo;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ArtigoRepository extends MongoRepository<Artigo, String> {

    public void deleteById(String codigo);
    public List<Artigo> findByStatusAndData(Integer status, LocalDateTime date);
    public List<Artigo> findByStatusEquals(Integer status);

    @Query("{ $and:  [ {'data': { $gte: ?0}}, {'data': { $lte: ?1}}]}")
    public List<Artigo> findByDateAndHour(LocalDateTime data, LocalDateTime hour);

    // Creating pagination
    // Sort pagination query
    Page<Artigo> findAll(Pageable pageable);

    List<Artigo> findByStatusOrderByTituloAsc(Integer status);

    // Everytime that we need a specific query, we can use @Query
    @Query(value = "{ 'status' : {$eq: ?0} }", sort = "{ 'titulo' : 1}")
    public List<Artigo> findByStatusAsc(Integer status);
}
