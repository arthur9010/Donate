package br.com.fiap.donate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.fiap.donate.service.UsuarioService;

@Entity
@Table(name = "TB_DTN_USUARIO")
public class Usuario {

	@Id
	@Column(name = "cd_usuario", length = 5, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "nm_usuario", length = 20, nullable = false)
	private String nome;

	
	@Column(name = "ds_email", length = 60, nullable = false)
	private String email;

	@Column(name = "ds_senha", length = 20, nullable = false)
	private String senha;

	@Lob
	@Column(name = "fl_usuario")
	private byte[] foto;
	
	
//	public Usuario update(Long id, UsuarioService usuarioService) {
//		Usuario usuario = usuarioService.getOne(id);
//		
//		usuario.setNome(this.nome);
//		usuario.setEmail(this.email);
//		usuario.setSenha(this.senha);
//		usuario.setFoto(this.foto);
//		
//		return usuario;
//	}	
	public Usuario() {
	}
	public Usuario(String nome, String email, String senha, byte[] foto) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
