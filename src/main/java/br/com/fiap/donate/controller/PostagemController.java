package br.com.fiap.donate.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.donate.model.Postagem;
import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.repository.PostagemRepository;

@RestController
@RequestMapping("/post")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;


	//FUNCIONANDO
	//http://localhost:8080/post
	@GetMapping
	public ResponseEntity<List<Postagem>> findAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	//FUNCIONANDO
	//http://localhost:8080/post
	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@Valid @RequestBody Postagem postagem) {	
		return ResponseEntity.ok(postagemRepository.save(postagem));
	}

	//FUNCIONANDO
	//http://localhost:8080/post/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> findById(@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		if (!postagem.isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postagem.get());
	}

	//FUNCIONANDO
	//http://localhost:8080/post/{id}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Postagem> update(@PathVariable Long id, @Valid @RequestBody Postagem postagem) {
		if (!postagemRepository.findById(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postagem.update(id, postagemRepository));
	}
	
//	@DeleteMapping("/{id}")
//	@Transactional
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		Optional<Postagem> optional = postagemRepository.findById(id);
//		if (optional.isPresent()) {
//			postagemRepository.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
}