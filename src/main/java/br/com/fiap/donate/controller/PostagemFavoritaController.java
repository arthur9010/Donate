package br.com.fiap.donate.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.donate.model.PostagemFavorita;
import br.com.fiap.donate.service.PostagemFavoritaService;

@RestController
@RequestMapping("/favorite/post")
public class PostagemFavoritaController {

	@Autowired
	private PostagemFavoritaService favoritaService;

	//FUNCIONANDO
	//http://localhost:8080/favorite/post
	@GetMapping
	public ResponseEntity<List<PostagemFavorita>> findAll() {
		return ResponseEntity.ok(favoritaService.findAll());
	}


	//FUNCIONANDO
	//http://localhost:8080/favorite/post/{id}
	@GetMapping("/{id}")
	public ResponseEntity<PostagemFavorita> findById(@PathVariable Long id) {
		Optional<PostagemFavorita> favorita = favoritaService.findById(id);
		if (!favorita.isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(favorita.get());
	}

	//FUNCIONANDO
	//http://localhost:8080/favorite/post/{id}
	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@Valid @RequestBody PostagemFavorita favorita) {	
		return ResponseEntity.ok(favoritaService.save(favorita));
	}
	
//	@DeleteMapping("/{id}")
//	@Transactional
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		Optional<PostagemFavorita> optional = favoritaService.findById(id);
//		if (optional.isPresent()) {
//			favoritaService.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
}
