package br.edu.ufj.CCP.dtos;

import java.io.Serializable;

import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import jakarta.validation.constraints.NotBlank;
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
public class ComentariosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private int codigo;
	
	@NotBlank
	private String texto;
	
	@NotBlank
	private Postagem postagem;
	
	@NotBlank
	private Usuario usuario;
	
	public ComentariosDTO(Comentarios obj) {
		this.codigo = obj.getCodigo();
		this.texto = obj.getTexto();
		this.postagem = obj.getPostagem();
		this.usuario = obj.getUsuario();
	}

}
