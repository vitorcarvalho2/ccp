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

import br.edu.ufj.CCP.dtos.PostagemDTO;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.services.PostagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ccp/postagem")
@Tag(name = "Endpoint de Postagem")
@CrossOrigin("*")

public class PostagemController {

	@Autowired
	private PostagemService service;
	
	
	@Operation(summary = "Busca todos as postagens por id")
	@GetMapping
	public ResponseEntity<Page<PostagemDTO>> buscartodos(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@Operation(summary = "Busca as postagens por id")
	@GetMapping("/id/{id}")
	public ResponseEntity<PostagemDTO> buscarum(@PathVariable Integer id){
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Operation(summary = "Busca todos as postagens por titulo")
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<PostagemDTO> buscarTitulo(@PathVariable String titulo){
		return service.findByTitulo(titulo)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	/*
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<PostagemDTO> buscarUsuario(@PathVariable Usuario usuario){
		return service.findByUsuario(usuario)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	*/
	@Operation(summary = "Insere postagens por id")
	@PostMapping
	public ResponseEntity<PostagemDTO> salvar(@RequestBody Postagem obj){
		@Valid PostagemDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}
    
	@Operation(summary = "Edita postagens por id")
	@PutMapping("/{id}")
	public ResponseEntity<PostagemDTO> atualizar(@Valid @PathVariable Integer id,@RequestBody Postagem obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	PostagemDTO objDTO = service.save(obj);
	
	return ResponseEntity.ok(objDTO);
	}

	@Operation(summary = "Deleta postagens por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
