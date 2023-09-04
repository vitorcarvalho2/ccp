package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufj.CCP.dtos.ComentariosDTO;
import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.repositories.ComentariosDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComentariosService {
	
	private ComentariosDAO commDAO;
	
	@Transactional
	
	public Page<ComentariosDTO> findAll(Pageable pageable){
		Page<Comentarios> result = commDAO.findAll(pageable);
		return result.map(obj -> new ComentariosDTO(obj));
	}
    @Transactional
 
    public Optional<ComentariosDTO> findById(Integer id){
    	Optional<Comentarios> result = commDAO.findById(id);
    	return result.map(obj -> new ComentariosDTO(obj));
    }
    
    @Transactional
    public Optional<ComentariosDTO> findByUsuario(Usuario usuario){
    	Optional<Comentarios> result = commDAO.findByUsuario(usuario);
    	return result.map(obj -> new ComentariosDTO(obj)); 
    	}
    
    @Transactional
    public Optional<ComentariosDTO> findByPostagem(Postagem postagem){
    	Optional<Comentarios> result = commDAO.findByPostagem(postagem);
    	return result.map(obj -> new ComentariosDTO(obj)); 
    	}
    
    @Transactional
	public ComentariosDTO save(Comentarios obj) {
		return new ComentariosDTO(commDAO.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		commDAO.deleteById(id);
	}

	public boolean existById(Integer id) {
		return commDAO.existsById(id);
	}
}
