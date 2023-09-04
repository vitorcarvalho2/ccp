package br.edu.ufj.CCP.dtos;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import br.edu.ufj.CCP.models.Comentarios;
import br.edu.ufj.CCP.models.Postagem;
import br.edu.ufj.CCP.models.Usuario;
import jakarta.validation.constraints.Email;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class UsuarioDTO extends RepresentationModel<UsuarioDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int codigo;
    
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String senha;
	
	private List<Postagem> postagens;
	
	private List<Comentarios> comentarios;

	public UsuarioDTO(Usuario obj) {
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	
	
}
