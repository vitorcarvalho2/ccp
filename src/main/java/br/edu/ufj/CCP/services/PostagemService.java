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
	
	private PostagemDAO postagemDAO;
	
	@Transactional
	public Page<PostagemDTO> findAll(Pageable pageable){
		Page<Postagem> result = postagemDAO.findAll(pageable);
		return result.map(obj -> new PostagemDTO(obj));
	}
    @Transactional
    public Optional<PostagemDTO> findById(Integer id){
    	Optional<Postagem> result = postagemDAO.findById(id);
    	return result.map(obj -> new PostagemDTO(obj));
    }
    
    @Transactional
    public Optional<PostagemDTO> findByTitle(String titulo){
    	Optional<Postagem> result = postagemDAO.findByTitle(titulo);
    	return result.map(obj -> new PostagemDTO(obj)); 
    	}
}
