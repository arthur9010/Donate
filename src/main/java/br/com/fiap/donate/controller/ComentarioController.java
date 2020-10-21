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

import br.com.fiap.donate.model.Comentario;
import br.com.fiap.donate.service.ComentarioService;

@RestController
@RequestMapping("/comment")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	//FUNCIONANDO
	//http://localhost:8080/comment
	@GetMapping
	public ResponseEntity<List<Comentario>> findAll() {
		return ResponseEntity.ok(comentarioService.findAll());
	}

	//FUNCIONANDO
	//http://localhost:8080/comment/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> findById(@PathVariable Long id) {
		Optional<Comentario> comentario = comentarioService.findById(id);
		if (!comentario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(comentario.get());
	}

	//FUNCIONANDO 
	//http://localhost:8080/comment/{id}
	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@Valid @RequestBody Comentario comentario) {	
		return ResponseEntity.ok(comentarioService.save(comentario));
	}


	//FUNCIONANDO 
	//http://localhost:8080/comment/{id}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Comentario> update(@PathVariable Long id, @Valid @RequestBody Comentario comentario) {
		if (!comentarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(comentarioService.update(id, comentario));
	}
	
	//http://localhost:8080/comment/post/{id}
	@GetMapping("post/{postId}")
	public ResponseEntity<List<Comentario>> findByComentarioPostId (@PathVariable Long postId) {
		Optional<List<Comentario>> comentarioPostagem = comentarioService.findByComentarioPostId(postId);
		if(!comentarioPostagem.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(comentarioPostagem.get());
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Comentario> optional = comentarioService.findById(id);
		if (optional.isPresent()) {
			comentarioService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
}
