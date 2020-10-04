package br.com.fiap.donate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.donate.model.Login;
import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//FUNCIONANDO
	@PostMapping
	public ResponseEntity<Usuario> login(@Valid @RequestBody Login login){
		Usuario usuario = usuarioService.findByEmail(login.getEmail());
		
		if(usuarioService.findByEmail(login.getEmail()) == null) {
			return ResponseEntity.notFound().build();
		}
		
		if(!login.getSenha().equals(usuario.getSenha())) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
}
