package br.ufc.modelo;

import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="noticia")
public class Noticia {

	@Id
	@Column(name="noticia_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNoticia;
	
	@Column(name="noticia_titulo",nullable=false)
	private String titulo;
	
	@Column(name="noticia_subtitulo",nullable=false)
	private String subtitulo;
	
	@Column(name="noticia_texto",nullable=false)
	private String texto;
	
	@Column(name="data_noticia")
	private String dataNoticia;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="usuario_id",
				referencedColumnName="usuario_id")
	private Usuario usuario;
	
	@Column(name="usuario_id",insertable=false,updatable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="secao_id",
				referencedColumnName="secao_id")
	private Secao secao;
	
	@Column(name="secao_id",insertable=false,updatable=false)
	private Long secaoId;
	
	@OneToMany(mappedBy="noticia",
			   targetEntity=Comentario.class,
			   fetch=FetchType.EAGER)
	private Collection<Comentario> comentario;

	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(String dataNoticia) {
		this.dataNoticia = dataNoticia;
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

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(Long secaoId) {
		this.secaoId = secaoId;
	}

	public Collection<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(Collection<Comentario> comentario) {
		this.comentario = comentario;
	}

	

	
	
	
}