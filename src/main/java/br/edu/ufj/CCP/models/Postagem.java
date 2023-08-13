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
import jakarta.persistence.ManyToOne;
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
@Table(name = "postagem")
public class Postagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_post")	
    private int codigo_post;
	
	@ManyToOne
	@JoinColumn(name="categoriaPostagem")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name= "pessoaPostagem")
	private Usuario usuario;
    
	@Column(name = "titulo_post", nullable = false)
	private String titulo;
	
	@Column(name = "post_post", nullable = false)
	private String post;
	
	@OneToMany
	@JoinColumn(name = "comentarioPostagem")
	@JsonIgnore
	private List<Comentarios> comentarios;

	public Postagem(int codigo_post,/* Categoria categoria,Usuario usuario,*/ String titulo, String post) {
		super();
		this.codigo_post = codigo_post;
		//this.categoria = categoria;
		//this.usuario = usuario;
		this.titulo = titulo;
		this.post = post;
	} 
	
	
	
}
