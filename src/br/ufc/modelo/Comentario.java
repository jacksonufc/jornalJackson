package br.ufc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="comentario")
public class Comentario {

	@Id
	@Column(name="comentario_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idComentario;
	
	@Column(name="comentario_texto",nullable=false)
	private String texto;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="usuario_id",
				referencedColumnName="usuario_id")
	private Usuario usuario;
	
	@Column(name="usuario_id",insertable=false,updatable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="noticia_id",
				referencedColumnName="noticia_id")
	private Noticia noticia;
	
	@Column(name="noticia_id",insertable=false,updatable=false)
	private Long noticiaId;

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	
	
	
}