package br.ufc.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="papel")
public class Papel {

	@Id
	@Column(name="papel_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPapel;
	
	@Column(name="papel",nullable=false)
	private String papel;
	
	@ManyToMany(mappedBy="papelList",fetch=FetchType.EAGER)
	private List<Usuario> usuarioList;

	public Long getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Long idPapel) {
		this.idPapel = idPapel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Papel))
			return false;
		Papel ref = (Papel)obj;
		if(ref.getIdPapel() == this.getIdPapel())
			return true;
		return false;
	}
*/
}