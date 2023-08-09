package br.edu.ufj.CCP.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Postagem;

public interface PostagemDAO extends JpaRepository<Postagem, Integer> {

	Optional<Postagem> findByTitle(String titulo);

}
