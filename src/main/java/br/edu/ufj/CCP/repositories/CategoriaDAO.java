package br.edu.ufj.CCP.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

	Optional<Categoria> findByDescricao(String descricao);

}
