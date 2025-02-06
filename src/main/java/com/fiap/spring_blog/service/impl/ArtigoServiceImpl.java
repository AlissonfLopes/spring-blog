package com.fiap.spring_blog.service.impl;

import com.fiap.spring_blog.model.Artigo;
import com.fiap.spring_blog.repository.ArtigoRepository;
import com.fiap.spring_blog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Override
    public List<Artigo> obterTodos() {
        return List.of();
    }

    @Override
    public List<Artigo> obterPorCodigo(String codigo) {
        return List.of();
    }

    @Override
    public Artigo criarArtigo(Artigo artigo) {
        return null;
    }
}
