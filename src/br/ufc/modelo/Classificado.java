package br.ufc.modelo;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="classificado")
public class Classificado {

	@Id
	@Column(name="classificado_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClassificado;
	
	@Column(name="classificado_titulo",nullable=false)
	private String titulo;
	
	@Column(name="classificado_texto",nullable=false)
	private String texto;
	
	@Column(name="classificado_preco",nullable=false)
	private float preco;
	
	@Column(name="classificado_telefone",nullable=false)
	private String telefone;
	
	@Column(name="classificado_melhor_oferta",nullable=false)
	private float melhorOferta;
	
	@Column(name="data_oferta")
	private String dataOferta;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="usuario_id",
				referencedColumnName="usuario_id")
	private Usuario usuario;
	
	@Column(name="usuario_id",insertable=false,updatable=false)
	private Long usuarioId;

	@Column(name="nome_leitor")
	private String nomeLeitor;
	
	public String getNomeLeitor() {
		return nomeLeitor;
	}

	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}

	public Long getIdClassificado() {
		return idClassificado;
	}

	public void setIdClassificado(Long idClassificado) {
		this.idClassificado = idClassificado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(float melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public String getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(String dataOferta) {
		this.dataOferta = dataOferta;
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

	

	
	
	
}