package com.fiap.spring_blog.service;

import com.fiap.spring_blog.model.Artigo;
import com.fiap.spring_blog.model.ArtigoStatusCount;
import com.fiap.spring_blog.model.AutorTotalArticles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ArtigoService {

    public List<Artigo> obterTodos();
    public Artigo obterPorCodigo(String codigo);
    public Artigo criarArtigo(Artigo artigo);
    public List<Artigo> findByDataGreaterThan(LocalDateTime data);
    public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status);
    public void atualizarArtigo(Artigo artigo);
    public void atualizarArtigoURL(String codigo, String URL);
    public void deleteById(String codigo);
    public void deleteArtigoById(String id);
    public List<Artigo> findByStatusAndData (Integer status, LocalDateTime data);
    public List<Artigo> findByStatusEquals(Integer status);
    public List<Artigo> findByDateAndHour(LocalDateTime data, LocalDateTime hour);
    public List<Artigo> findComplexArticles(Integer status, LocalDateTime date, String titulo);
    public Page<Artigo> findAll(Pageable pageable);
    public List<Artigo> findByStatusOrderByTituloAsc(Integer status);
    public List<Artigo> findByStatusAsc(Integer status);
    public List<Artigo> findByTexto(String searchTerm);
    public List<ArtigoStatusCount> countArticlesByStatus();
    public List<AutorTotalArticles> countArticlesByAutor();
    public List<AutorTotalArticles> countArticlesByAutorAndPeriod(LocalDate initDate, LocalDate endDate);
}
