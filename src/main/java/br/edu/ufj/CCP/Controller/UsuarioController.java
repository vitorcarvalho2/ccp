package br.edu.ufj.CCP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ccp/usuario")
@Tag(name = "Endpoint de Usuario")
@CrossOrigin("*")

public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	@Operation(summary = "Busca todos os usuarios")
	public ResponseEntity<Page<UsuarioDTO>> buscartodos(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/id/{id}")
	@Operation(summary = "Busca Usuarios por id")
	public ResponseEntity<UsuarioDTO> buscarum(@PathVariable Integer id){
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/email/{email}")
	@Operation(summary = "Busca Usuarios por email")
	public ResponseEntity<UsuarioDTO> buscarporEmail(@PathVariable String email){
		return service.findByEmail(email)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca usuarios por nome")
	public ResponseEntity<UsuarioDTO> buscarporNome(@PathVariable String nome){
		return service.findByNome(nome)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@Operation(summary = "Insere um novo Usuario")
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario obj){
		@Valid UsuarioDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Edita um Usuario existente")
	public ResponseEntity<UsuarioDTO> atualizar(@Valid @PathVariable Integer id,@RequestBody Usuario obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	UsuarioDTO objDTO = service.save(obj);
	
	return ResponseEntity.ok(objDTO);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui Usuario por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
