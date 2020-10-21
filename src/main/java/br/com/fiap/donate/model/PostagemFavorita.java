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
@Table(name = "TB_DTN_POSTAGEM_FAVORITA")
public class PostagemFavorita {
	
	@Id
	@Column(name = "cd_postagem_favorita", length = 5, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * Relacionamento muitos para um
	 * Muitas postagens favoritas DEVE ser de um usuário
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cd_usuario", nullable = false)
	private Usuario usuario;
	
	/*
	 * Relacionamento muitos para um
	 * Muitas postagens favoritas DEVE ser uma postagens
	 */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cd_postagem", nullable = false)
	private Postagem postagem;
	

	public PostagemFavorita() {
	}

	public PostagemFavorita(Postagem postagem, Usuario usuario) {
		this.usuario = usuario;
		this.postagem = postagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PostagemFavorita other = (PostagemFavorita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
