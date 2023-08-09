package br.edu.ufj.CCP.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "comentarios")
public class Comentarios implements Serializable {
	 private static final long serialVersionUID = 1L;
		
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_comm", nullable = false)
	private int codigo_Comentario;
	
	@Column(name = "texto_comm", nullable = false)
	private String texto;
	
	@ManyToOne
	@JoinColumn(name= "comentarioPostagem")
	private Postagem postagem;
	
	@ManyToOne
	@JoinColumn(name= "usuarioComentario")
	private Usuario usuario;
}
