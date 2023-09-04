package br.edu.ufj.CCP.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Categoria_PostagemPK {

	@ManyToOne
	@JoinColumn(name = "codigo_cat")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "codigo_post")
	private Postagem postagem;
}
