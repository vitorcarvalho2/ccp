package br.edu.ufj.CCP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufj.CCP.dtos.UsuarioDTO;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ccp/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> buscartodos(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<UsuarioDTO> buscarum(@PathVariable Integer id){
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario obj){
		@Valid UsuarioDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@Valid @PathVariable Integer id,@RequestBody Usuario obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	UsuarioDTO objDTO = service.save(obj);
	
	return ResponseEntity.ok(objDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}