package br.edu.ufj.CCP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Usuario;


public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
