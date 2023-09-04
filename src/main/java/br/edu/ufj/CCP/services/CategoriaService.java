package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufj.CCP.dtos.CategoriaDTO;
import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.repositories.CategoriaDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {
	
	private CategoriaDAO catDAO;
	
	@Transactional
	public Page<CategoriaDTO> findAll(Pageable pageable){
		Page<Categoria> result = catDAO.findAll(pageable);
		return result.map(obj -> new CategoriaDTO(obj));
	}
	
    @Transactional
    public Optional<CategoriaDTO> findById(Integer id){
    	Optional<Categoria> result = catDAO.findById(id);
    	return result.map(obj -> new CategoriaDTO(obj));
    }
    
    @Transactional
    public Optional<CategoriaDTO> findByDescricao(String descricao){
    	Optional<Categoria> result = catDAO.findByDescricao(descricao);
    	return result.map(obj -> new CategoriaDTO(obj));
    }
    
    @Transactional
	public CategoriaDTO save(Categoria obj) {
		return new CategoriaDTO(catDAO.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		catDAO.deleteById(id);
	}

	public boolean existById(Integer id) {
		return catDAO.existsById(id);
	}
}
