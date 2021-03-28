package com.diegosena.agenda.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class CategoriaLivros implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "categoriaLivros")
    private List<Livro> livros;

    public CategoriaLivros() {
        super();
    }

    public CategoriaLivros(Integer id, String nome, String descricao) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoriaLivros other = (CategoriaLivros) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}