package br.com.fiap.donate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.repository.ComentarioRepository;
import br.com.fiap.donate.repository.PostagemFavoritaRepository;
import br.com.fiap.donate.repository.PostagemRepository;
import br.com.fiap.donate.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PostagemRepository postagemRepository; 
	@Autowired
	private PostagemFavoritaRepository favoritaRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;

	
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

	public void deleteById(Long userId) {
		postagemRepository.deleteByUsuarioCodigo(userId);
		//favoritaRepository.deleteByUsuarioCodigo(userId);
		//comentarioRepository.deleteByUsuarioCodigo(userId);
		usuarioRepository.deleteById(userId);
	}

	public Usuario update(Long id, Usuario user) {
		Usuario usuario = usuarioRepository.getOne(id);
			
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
		usuario.setFoto(user.getFoto());
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
}