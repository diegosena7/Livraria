package com.diegosena.agenda;

import com.diegosena.agenda.domain.CategoriaLivros;
import com.diegosena.agenda.domain.Livro;
import com.diegosena.agenda.repository.CategoriaRepository;
import com.diegosena.agenda.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AgendaApplication {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//Instanciando um objeto do tipo Categoria
//		CategoriaLivros categoriaLivros = new CategoriaLivros(1, "BackEnd", "Livros de Java");
//
//		//Instanciando um objeto do tipo Livro
//		Livro livro = new Livro(1, "Java Orientado a Objetos", "Mark Newlls", "Tudo de Java da verão 8 em diante", categoriaLivros);
//
//		//Passando para a categoria a lista de livros
//		categoriaLivros.getLivros().addAll(Arrays.asList(livro));
//
//		//Salvando os objetos categoria e livro no banco
//		this.categoriaRepository.saveAll(Arrays.asList(categoriaLivros));
//		this.livroRepository.saveAll(Arrays.asList(livro));
//	}
}
