package br.edu.ufj.CCP.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;

public interface ComentariosDAO extends JpaRepository<Comentarios, Integer>{

	Optional<Comentarios> findByUsuario(Usuario usuario);

	Optional<Comentarios> findByPostagem(Postagem postagem);

}
