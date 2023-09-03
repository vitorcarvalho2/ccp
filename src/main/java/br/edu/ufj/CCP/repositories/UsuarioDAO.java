package br.edu.ufj.CCP.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Usuario;


public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNome(String nome);
}
