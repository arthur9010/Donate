package br.com.fiap.donate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.donate.repository.PostagemRepository;



@Entity
@Table(name = "TB_DTN_POSTAGEM")
public class Postagem {

	@Id
	@Column(name = "cd_postagem", length = 5, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Lob
	@Column(name = "fl_postagem")
	private byte[] foto;
	
	@Column(name = "ds_postagem", length = 1000, nullable = false)
	private String texto;
	
	/*
	 * Relacionamento um para muitos
	 * Muitas postagens DEVE ser de um usuário 
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;
	
	/*
	 * Relacionamento muitos para muitos
	 * Vários usuários podem reagir a várias postagens
	 */
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "TB_DTN_POSTAGEM_REACAO",
	joinColumns = @JoinColumn(name = "cd_postagem"),
	inverseJoinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Usuario> usuarios;
	
	
	
	public Postagem update(Long id, PostagemRepository postagemRepository) {
		Postagem postagem = postagemRepository.getOne(id);
		
		postagem.setFoto(this.foto);
		postagem.setTexto(this.texto);
		
		return postagem;
	}
	public Postagem() {
	}
	public Postagem(byte[] foto, String texto, Usuario usuario) {
		super();
		this.foto = foto;
		this.texto = texto;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
