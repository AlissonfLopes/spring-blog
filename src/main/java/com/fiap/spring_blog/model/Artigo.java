package com.fiap.spring_blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

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
    @DBRef
    private Autor autor;

}
