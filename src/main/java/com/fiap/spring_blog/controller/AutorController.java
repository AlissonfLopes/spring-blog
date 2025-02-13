package com.fiap.spring_blog.controller;

import com.fiap.spring_blog.model.Autor;
import com.fiap.spring_blog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("{codigo}")
    public Autor listarAutorPorId(@PathVariable String codigo) {
        return autorService.listarAutorPorId(codigo);
    }

    @GetMapping("/procurarNome")
    public List<Autor> procurarPorNome(@RequestParam String nome) {
        return autorService.listarAutorPorNome(nome);
    }

    @PostMapping
    public Autor inserirAutor(@RequestBody Autor autor) {
        return autorService.salvarAutor(autor);
    }
}
