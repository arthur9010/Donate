package br.com.fiap.donate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario update(Long id, Usuario user) {
		Optional<Usuario> usuarioOP = usuarioRepository.findById(id);
			
		Usuario usuario = usuarioOP.get();
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
		usuario.setFoto(user.getFoto());
		
		return usuarioRepository.save(usuario);
	}
	
//	public Usuario getOne(Long id){
//		return usuarioRepository.getOne(id);
//	}
}