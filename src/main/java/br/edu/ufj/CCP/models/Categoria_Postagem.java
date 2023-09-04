package br.edu.ufj.CCP.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categoria_Postagem")
public class Categoria_Postagem {

	@EmbeddedId
	private Categoria_PostagemPK id = new Categoria_PostagemPK();
	
}
