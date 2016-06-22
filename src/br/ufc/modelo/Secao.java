package br.ufc.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="secao")
public class Secao {

	@Id
	@Column(name="secao_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idSecao;
	
	@Column(name="secao_titulo",nullable=false)
	private String titulo;
	
	@Column(name="secao_descricao",nullable=false)
	private String descricao;
	
	@OneToMany(mappedBy="secao",
			   targetEntity=Noticia.class,
			   fetch=FetchType.EAGER)
	private Collection<Noticia> noticia;

	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Noticia> getNoticia() {
		return noticia;
	}

	public void setNoticia(Collection<Noticia> noticia) {
		this.noticia = noticia;
	}

	
	
	
}