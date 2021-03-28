package com.diegosena.agenda.repository;

import com.diegosena.agenda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Utilizado a anotação @Repository para definir uma classe como pertencente à camada de Serviço da aplicação
que seria a classe de acesso a dados. Essa classe extends JpaRepository, informando qual a classe e o tipo
primitivo ao qual nosso id da classe pertence.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
