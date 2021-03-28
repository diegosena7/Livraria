package com.diegosena.agenda.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Utilizado as anotações do Lombok, @Id onde é referenciada a PK e @ a @Entity referencia
a classe como uma Entidade e na PK usamos a anotação @GeneratedValue para gerar automaticamente
a sequência do Id do tipo IDENTITY.

(Obs: não utilizado a anotação @Column, pois se não passarmos o nome da coluna o JPA vai criar
as colunas com o mesmo nome dos atributos da classe).

Usado as anotações @OneToMany para inidicar que teremos 1 livro muitas para categorias
e o parametro mappedBy que fica dentro do @OneToMany é usado no lado fraco do relacionamento.
 */
@Entity
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();

    //Construtor sem parâmetros
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    //Getters and seters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    //Equals and haschcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
