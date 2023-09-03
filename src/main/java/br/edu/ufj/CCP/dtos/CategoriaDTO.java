package br.edu.ufj.CCP.dtos;

import java.io.Serializable;
import java.util.List;

import br.edu.ufj.CCP.models.Categoria;
import br.edu.ufj.CCP.models.Postagem;
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
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private int codigo;
	
	@NotBlank
	private String categoria_cat;
	
    private List<Postagem> postagem;
	
	public CategoriaDTO(Categoria obj) {
		this.codigo = obj.getCodigo();
		this.categoria_cat = obj.getCategoria_cat();
	}

}
