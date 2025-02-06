package com.fiap.spring_blog.service;

import com.fiap.spring_blog.model.Artigo;

import java.util.List;

public interface ArtigoService {

    public List<Artigo> obterTodos();
    public List<Artigo> obterPorCodigo(String codigo);
    public Artigo criarArtigo(Artigo artigo);

}
