package br.com.fiap.donate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.PostagemFavorita;
import br.com.fiap.donate.repository.PostagemFavoritaRepository;

@Service
public class PostagemFavoritaService {

	@Autowired
	private PostagemFavoritaRepository favoritaRepository;

	public PostagemFavoritaService(PostagemFavoritaRepository favoritaRepository) {
		this.favoritaRepository = favoritaRepository;
	}
	
	public List<PostagemFavorita> findAll() {
		return favoritaRepository.findAll();
	}
	
	public Optional<PostagemFavorita> findById(Long id) {
		return favoritaRepository.findById(id);
	}
	
	public PostagemFavorita save(PostagemFavorita favorita) {
		return favoritaRepository.save(favorita);
	}
	
	public void deleteById(Long id) {
		favoritaRepository.deleteById(id);
	}
	
}
