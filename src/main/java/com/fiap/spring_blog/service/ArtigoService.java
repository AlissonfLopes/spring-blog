package com.fiap.spring_blog.service;

import com.fiap.spring_blog.model.Artigo;

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

}
