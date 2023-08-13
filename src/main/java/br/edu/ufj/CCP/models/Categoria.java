package br.edu.ufj.CCP.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "usuario")
public class Categoria implements Serializable {
	 private static final long serialVersionUID = 1L;
		
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_Cat")
	private int codigo_Cat; 
	
	/*
	@Column(name = "linguagem_Cat")
	private String Linguagem;
	
	@Column(name = "status_Cat")
	private int Status;//1- finalizado  2- incompleto
	*/
	
	@Column(name = "categoria_cat")
	private String categoria_cat;
	
	@OneToMany
	@JoinColumn( name= "categoriaPostagem")
	@JsonIgnore
	private List<Postagem> postagens;

	public Categoria(int codigo_Cat, String categoria_cat) {
		super();
		this.codigo_Cat = codigo_Cat;
		this.categoria_cat = categoria_cat;
	}
	
	
}
