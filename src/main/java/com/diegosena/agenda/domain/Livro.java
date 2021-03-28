package com.diegosena.agenda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
    private String nome_autor;

    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    private CategoriaLivros categoriaLivros;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, CategoriaLivros categoriaLivros) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoriaLivros = categoriaLivros;
    }

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

    public CategoriaLivros getCategoria() {
        return categoriaLivros;
    }

    public void setCategoria(CategoriaLivros categoriaLivros) {
        this.categoriaLivros = categoriaLivros;
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
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
