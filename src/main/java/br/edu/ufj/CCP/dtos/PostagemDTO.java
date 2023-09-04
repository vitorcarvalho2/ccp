package br.edu.ufj.CCP.dtos;

import java.io.Serializable;
import java.util.List;

import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int codigo;
	
	@NotNull
	@Valid
	private Categoria categoria;
	
    @NotNull
    @Valid
	private Usuario usuario;
	
	private List<Comentarios> comentarios;
    
	@NotBlank
	@Size(max = 60)
	private String titulo;
	
	@NotBlank
	private String post;
	
	

	public PostagemDTO(Postagem obj) {
		this.codigo = obj.getCodigo();
		this.categoria = obj.getCategoria();
		this.usuario = obj.getUsuario();
		this.comentarios = obj.getComentarios();
		this.titulo = obj.getTitulo();
		this.post = obj.getPost();
	}

	
	
}
