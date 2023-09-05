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

import br.edu.ufj.CCP.dtos.ComentariosDTO;
import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import br.edu.ufj.CCP.services.ComentariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ccp/comentarios")
@Tag(name = "Endpoint de Comentarios")
public class ComentariosController {

	@Autowired
	private ComentariosService service;
	
	@GetMapping
	@Operation(summary = "Busca todas os comentarios")
	public ResponseEntity<Page<ComentariosDTO>> buscartodos(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/id/{id}")
	@Operation(summary = "Busca comentarios por ID")
	public ResponseEntity<ComentariosDTO> buscarum(@PathVariable Integer id){
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario/{usuario}")
	@Operation(summary = "Busca comentarios por Usuario")
	public ResponseEntity<ComentariosDTO> buscarUsuario(@PathVariable Usuario usuario){
		return service.findByUsuario(usuario)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/postagem/{postagem}")
	@Operation(summary = "Busca comentarios por Postagem")
	public ResponseEntity<ComentariosDTO> buscarPostagem(@PathVariable Postagem postagem){
		return service.findByPostagem(postagem)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@Operation(summary = "Insere um novo Comentario")
	public ResponseEntity<ComentariosDTO> salvar(@RequestBody Comentarios obj){
		@Valid ComentariosDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Edita um comentario existente")
	public ResponseEntity<ComentariosDTO> atualizar(@Valid @PathVariable Integer id,@RequestBody Comentarios obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	ComentariosDTO objDTO = service.save(obj);
	
	return ResponseEntity.ok(objDTO);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um comentario por ID")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
