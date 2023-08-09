package br.edu.ufj.CCP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Comentarios;

public interface ComentarioDAO extends JpaRepository<Comentarios, Integer>{

}
