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
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_usuario")
	private int codigo;
	
	@Column( name= "nome_usuario",nullable = false)
	private String nome;
	
	
	@Column(name = "email_usuario", nullable = false)
	private String email;

	@Column(name = "senha_usuario",nullable = false)
	private String senha;
	
	
	@OneToMany
	@JoinColumn(name= "pessoaPostagem")
	@JsonIgnore
	private List<Postagem> postagens;
	
	@OneToMany
	@JoinColumn(name= "usuarioComentario")
	private List<Comentarios> comentarios;

	public Usuario(int codigo, String nome, String email, String senha) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	
}
