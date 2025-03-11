package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository) {
		return args -> {
			System.out.println("---- Inserindo Cursos ----");
			cursoRepository.salvar(
					new Curso(null, "teste", 2000));
			cursoRepository.salvar(
					new Curso(null, "teste2", 2050));
			System.out.println("---- Listando Cursos ----");
			List<Curso> listaCursos = cursoRepository.obterTodos();
			listaCursos.forEach(System.out::println);
			System.out.println(" --- Insere Categoria ---");
			CategoriaCurso categ = categoriaRepository.salvar(
					new CategoriaCurso(null,  "Informático"));
			System.out.println("--- Vincular Curso na Categoria ---");
			Curso c1 = cursoRepository.obterTodos().get(0);
			c1.setCategoriaCurso(categ);
			cursoRepository.salvar(c1);	
		};


	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
