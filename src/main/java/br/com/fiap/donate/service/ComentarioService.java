package br.com.fiap.donate.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.Comentario;
import br.com.fiap.donate.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	public ComentarioService(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	public List<Comentario> findAll() {
		return comentarioRepository.findAll();
	}

	public Optional<Comentario> findById(Long id) {
		return comentarioRepository.findById(id);
	}

	public Comentario save(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	public void deleteById(Long id) {
		comentarioRepository.deleteById(id);
	}
	
	public Comentario update(Long id, Comentario comment) {
		Comentario comentario = comentarioRepository.getOne(id);
		
		comentario.setTexto(comment.getTexto());
		
		return comentarioRepository.save(comentario);
	}
}
