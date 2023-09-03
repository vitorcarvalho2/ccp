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

import br.edu.ufj.CCP.dtos.CategoriaDTO;
import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.services.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ccp/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> buscartodos(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CategoriaDTO> buscarum(@PathVariable Integer id){
		return service.findById(id)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> salvar(@RequestBody Categoria obj){
		@Valid CategoriaDTO objDTO = service.save(obj);
		return ResponseEntity.created(null).body(objDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> atualizar(@Valid @PathVariable Integer id,@RequestBody Categoria obj){
	if(!service.existById(id)) {
		return ResponseEntity.notFound().build();
	}
	obj.setCodigo(id);
	
	CategoriaDTO objDTO = service.save(obj);
	
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
