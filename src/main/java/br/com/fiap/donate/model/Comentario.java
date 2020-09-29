package br.com.fiap.donate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DTN_COMENTARIO")
public class Comentario {

	@Id
	@Column(name = "cd_comentario", length = 5, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "ds_comentario", length = 400, nullable = false)
	private String texto;
	
	/*
	 * Relacionamento muitos para um
	 * Muitos comentários DEVE ser de uma postagem
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cd_postagem", nullable = false)
	private Postagem postagem;
	
	
	/*
	 * Relacionamento um para muitos
	 * Muitos comentários DEVE ser de um usuário
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;
	
	

	public Comentario() {
	}
	public Comentario(String texto, Postagem postagem, Usuario usuario) {
		this.texto = texto;
		this.postagem = postagem;
		this.usuario = usuario;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Postagem getPostagem() {
		return postagem;
	}
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Comentario other = (Comentario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
