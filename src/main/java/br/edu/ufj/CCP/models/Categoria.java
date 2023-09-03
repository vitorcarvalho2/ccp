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
// entre cateoria e postagem a um many to many. olhar no github na aula 15

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
	private int codigo; 
	
	@Column(name = "categoria_cat")
	private String categoria_cat;
	
	@OneToMany
	@JoinColumn( name= "categoriaPostagem")
	@JsonIgnore
	private List<Postagem> postagens;

	public Categoria(int codigo, String categoria_cat) {

		this.codigo = codigo;
		this.categoria_cat = categoria_cat;
	}
	
	
}
