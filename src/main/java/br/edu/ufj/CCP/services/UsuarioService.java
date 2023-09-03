package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ufj.CCP.dtos.UsuarioDTO;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.repositories.UsuarioDAO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
	
	private UsuarioDAO userDAO;
	
	@Transactional
	public Page<UsuarioDTO> findAll(Pageable pageable){
		Page<Usuario> result = userDAO.findAll(pageable);
		return result.map(obj -> new UsuarioDTO(obj));
	}
    @Transactional
    public Optional<UsuarioDTO> findById(Integer id){
    	Optional<Usuario> result = userDAO.findById(id);
    	return result.map(obj -> new UsuarioDTO(obj));
    }
    
    @Transactional
	public UsuarioDTO save(Usuario obj) {
		return new UsuarioDTO(userDAO.save(obj));
	}

	@Transactional
	public void deleteById(Integer id) {
		userDAO.deleteById(id);
	}

	public boolean existById(Integer id) {
		return userDAO.existsById(id);
	}
}