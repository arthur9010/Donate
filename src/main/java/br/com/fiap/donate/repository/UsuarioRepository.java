package br.com.fiap.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.donate.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
