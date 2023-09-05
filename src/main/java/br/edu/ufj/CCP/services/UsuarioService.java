package br.edu.ufj.CCP.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufj.CCP.dtos.UsuarioDTO;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.repositories.UsuarioDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO userDAO;
	
	@Transactional(readOnly = true)
	public Page<UsuarioDTO> findAll(Pageable pageable){
		Page<Usuario> result = userDAO.findAll(pageable);
		return result.map(obj -> new UsuarioDTO(obj));
	}
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findById(Integer id){
    	Optional<Usuario> result = userDAO.findById(id);
    	return result.map(obj -> new UsuarioDTO(obj));
    }
    
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findByEmail(String email){
    	Optional<Usuario> result = userDAO.findByEmail(email);
    	return result.map(obj -> new UsuarioDTO(obj));
    }
    
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findByNome(String nome){
    	Optional<Usuario> result = userDAO.findByNome(nome);
    	return result.map(obj -> new UsuarioDTO(obj));
    }
    
    @Transactional
	public UsuarioDTO save(Usuario obj) {
    	/*
    	boolean emailExists = userDAO.findByEmail(obj.getEmail())
    			.stream()
    			.anyMatch(objResult -> !objResult.equals(obj));
    	if (emailExists) {
    		throw new BusinessException("E-mail já existente!");
    	}*/
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
