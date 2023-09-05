package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.CCP.dtos.PostagemDTO;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.repositories.PostagemDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostagemService {
	
	@Autowired
	private PostagemDAO postDAO;
	
	@Transactional(readOnly = true)
	public Page<PostagemDTO> findAll(Pageable pageable){
		Page<Postagem> result = postDAO.findAll(pageable);
		return result.map(obj -> new PostagemDTO(obj));
	}
    @Transactional(readOnly = true)
    public Optional<PostagemDTO> findById(Integer id){
    	Optional<Postagem> result = postDAO.findById(id);
    	return result.map(obj -> new PostagemDTO(obj));
    }
    
    @Transactional(readOnly = true)
    public Optional<PostagemDTO> findByTitulo(String titulo){
    	Optional<Postagem> result = postDAO.findByTitulo(titulo);
    	return result.map(obj -> new PostagemDTO(obj)); 
    	}
    /*
    @Transactional(readOnly = true)
    public Optional<PostagemDTO> findByUsuario(Usuario usuario){
    	Optional<Postagem> result = postDAO.findByUsuario(usuario);
    	return result.map(obj -> new PostagemDTO(obj)); 
    	}
    */
    @Transactional
	public PostagemDTO save(Postagem obj) {
		return new PostagemDTO(postDAO.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		postDAO.deleteById(id);
	}

	public boolean existById(Integer id) {
		return postDAO.existsById(id);
	}
}
