package com.fiap.spring_blog.service;

import com.fiap.spring_blog.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutorService {

    public List<Autor> listarAutores();
    public Autor listarAutorPorId(String codigoAutor);
    public Autor salvarAutor(Autor autor);
    public List<Autor> listarAutorPorNome(String nomeAutor);
}
