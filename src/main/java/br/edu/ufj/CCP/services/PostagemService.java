package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufj.CCP.dtos.PostagemDTO;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.repositories.PostagemDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostagemService {
	
	private PostagemDAO postDAO;
	
	@Transactional
	
	public Page<PostagemDTO> findAll(Pageable pageable){
		Page<Postagem> result = postDAO.findAll(pageable);
		return result.map(obj -> new PostagemDTO(obj));
	}
    @Transactional
    public Optional<PostagemDTO> findById(Integer id){
    	Optional<Postagem> result = postDAO.findById(id);
    	return result.map(obj -> new PostagemDTO(obj));
    }
    
    @Transactional
    public Optional<PostagemDTO> findByTitulo(String titulo){
    	Optional<Postagem> result = postDAO.findByTitulo(titulo);
    	return result.map(obj -> new PostagemDTO(obj)); 
    	}
    
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
