package br.com.fiap.donate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.Postagem;
import br.com.fiap.donate.repository.PostagemRepository;


@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository postagemRepository;

	public PostagemService(PostagemRepository postagemRepository) {
		this.postagemRepository = postagemRepository;
	}
	
	public List<Postagem> findAll() {
		return postagemRepository.findAll();
	}

	public Optional<Postagem> findById(Long id) {
		return postagemRepository.findById(id);
	}

	public Postagem save(Postagem postagem) {
		return postagemRepository.save(postagem);
	}

	public void deleteById(Long id) {
		postagemRepository.deleteById(id);
	}
	
	public Postagem update(Long id, Postagem post) {
		Postagem postagem = postagemRepository.getOne(id);
		
		postagem.setTexto(post.getTexto());
		postagem.setFoto(post.getFoto());
		
		return postagemRepository.save(postagem);
	}
}
