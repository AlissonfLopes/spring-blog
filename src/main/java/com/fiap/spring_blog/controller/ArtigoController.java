package com.fiap.spring_blog.controller;

import com.fiap.spring_blog.model.Artigo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoController {

    @GetMapping
    public List<Artigo> obterArtigos() {
        return null;
    }

    @GetMapping("/{codigo}")
    public List<Artigo> obterPorCodigo(@PathVariable String codigo) {
        return null;
    }

    @PostMapping
    public Artigo criarArtigo(@RequestBody Artigo artigo) {
        return null;
    }
}
