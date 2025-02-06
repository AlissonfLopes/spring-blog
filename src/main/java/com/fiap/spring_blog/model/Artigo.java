package com.fiap.spring_blog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Artigo {

    @Id
    private String codigo;
    private String titulo;
    private LocalDateTime data;
    private String texto;
    private String url;
    private Integer status;

    public Artigo() {
        this.codigo = "";
        this.titulo = "";
        this.data = LocalDateTime.now();
        this.texto = "";
        this.url = "";
        this.status = 0;
    }

    public Artigo(String codigo, String titulo, LocalDateTime data, String texto, String url, Integer status) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.data = data;
        this.texto = texto;
        this.url = url;
        this.status = status;
    }

    /*
     * Getters and Setters
     */


}
