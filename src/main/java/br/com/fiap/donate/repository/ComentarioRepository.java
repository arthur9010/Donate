package br.com.fiap.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.donate.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
