package com.diegosena.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;

/*
Utilizado as anotações do Lombok, @Id onde é referenciada a PK e @ a @Entity referencia
a classe como uma Entidade e na PK usamos a anotação @GeneratedValue para gerar automaticamente
a sequência do Id do tipo IDENTITY.

(Obs: não utilizado a anotação @Column, pois se não passarmos o nome da coluna o JPA vai criar
as colunas com o mesmo nome dos atributos da classe).

Usado as anotações @ManyToOne para inidicar que teremos muitas categorias para 1 livro.
A anotação @JoinColumn indica que a classe na qual você está utilizando-a é a dona ou o
lado forte do relacionamento, adicionando uma coluna estrangeira na classe.
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //Construtor sem argumentos
    public Livro() {
    }

    //Construtor com todos os atributos e parâmetros
    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    //Getters and seters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
