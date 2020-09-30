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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;


	//FUNCIONANDO
	//http://localhost:8080/user
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	//FUNCIONANDO, mas está sem validação de e-mail repetido
	//http://localhost:8080/user
	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario) {	
		return ResponseEntity.ok(usuarioService.save(usuario));
	}

	//FUNCIONANDO
	//http://localhost:8080/user/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		if (!usuario.isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario.get());
	}


	//FUNCIONANDO
	//http://localhost:8080/user/{id}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Usuario> update(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		if (!usuarioService.findById(id).isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarioService.update(id, usuario));
	}

	//Não remove pq tem fk em outras tabelas
//	@DeleteMapping("/{id}")	
//	@Transactional
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		Optional<Usuario> optional = usuarioService.findById(id);
//		if (optional.isPresent()) {
//			usuarioService.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
}
