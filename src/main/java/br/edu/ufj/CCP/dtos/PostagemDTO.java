package br.edu.ufj.CCP.dtos;

import java.io.Serializable;
import java.util.List;

import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import jakarta.validation.constraints.NotBlank;
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
	private int codigo_post;
	
	@NotBlank
	private Categoria categoria;
	
    @NotBlank
	private Usuario usuario;
    
	@NotBlank
	@Size(max = 60)
	private String titulo;
	
	@NotBlank
	private int post;
	
	@NotBlank
	private List<Comentarios> comentarios;

	public PostagemDTO(Postagem obj) {
		this.codigo_post = obj.getCodigo_post();
		this.categoria = obj.getCategoria();
		this.usuario = obj.getUsuario();
		this.titulo = obj.getTitulo();
		this.post = obj.getPost();
		this.comentarios = obj.getComentarios();
	}

	
	
}
