package br.ufc.modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario {

	@Id
	@Column(name="usuario_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(name="usuario_login",nullable=false)
	private String login;
	
	@Column(name="usuario_senha",nullable=false)
	private String senha;
	
	@Column(name="usuario_nome",nullable=false)
	private String nome;
	
	@Column(name="usuario_email",nullable=false)
	private String email;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Classificado.class,
			   fetch=FetchType.EAGER)
	private Collection<Classificado> classificado;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Noticia.class,
			   fetch=FetchType.EAGER)
	private Collection<Noticia> noticia;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Comentario.class,
			   fetch=FetchType.EAGER)
	private Collection<Comentario> comentario;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_papel",
		joinColumns=@JoinColumn(name="usuario_id",
					   		    referencedColumnName="usuario_id"),
	    inverseJoinColumns=@JoinColumn(name="papel_id",
					   				   referencedColumnName="papel_id")
			   
	)
	private List<Papel> papelList;

	
	
	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Collection<Classificado> getClassificado() {
		return classificado;
	}



	public void setClassificado(Collection<Classificado> classificado) {
		this.classificado = classificado;
	}



	public Collection<Noticia> getNoticia() {
		return noticia;
	}



	public void setNoticia(Collection<Noticia> noticia) {
		this.noticia = noticia;
	}



	public Collection<Comentario> getComentario() {
		return comentario;
	}



	public void setComentario(Collection<Comentario> comentario) {
		this.comentario = comentario;
	}



	public List<Papel> getPapelList() {
		return papelList;
	}



	public void setPapelList(List<Papel> papelList) {
		this.papelList = papelList;
	}


/*
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Usuario))
			return false;
		Usuario ref = (Usuario)obj;
		if(ref.getIdUsuario() == this.getIdUsuario())
			return true;
		return false;
	}
*/
}