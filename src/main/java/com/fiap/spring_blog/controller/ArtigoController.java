package com.fiap.spring_blog.controller;

import com.fiap.spring_blog.model.Artigo;
import com.fiap.spring_blog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping
    public List<Artigo> obterArtigos() {
        return this.artigoService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Artigo obterPorCodigo(@PathVariable String codigo) {
        return this.artigoService.obterPorCodigo(codigo);
    }

    @GetMapping("/maiordata")
    public List<Artigo> pesquisarPorData(@RequestParam LocalDateTime data) {
        return this.artigoService.findByDataGreaterThan(data);
    }

    @PostMapping
    public Artigo criarArtigo(@RequestBody Artigo artigo) {
        return this.artigoService.criarArtigo(artigo);
    }

    @GetMapping("/data-status")
    public List<Artigo> pesquisarPorDataAndStatus(@RequestParam LocalDateTime data, @RequestParam Integer status) {
        return  this.artigoService.findByDataAndStatus(data, status);
    }

    @PutMapping
    public void atualizarArtigo(@RequestBody Artigo artigo) {
        this.artigoService.atualizarArtigo(artigo);
    }

    @PutMapping("/{codigo}")
    public void atualizarArtigoURL(@PathVariable String codigo, @RequestBody String url) {
        this.artigoService.atualizarArtigoURL(codigo, url);
    }

    @DeleteMapping("/{id}")
    public void deletarArtigo(@PathVariable String id) {
        this.artigoService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deletarArtigosPorId(@RequestParam("id") String id) {
        this.artigoService.deleteArtigoById(id);
    }
}
