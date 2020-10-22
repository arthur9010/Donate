package br.com.fiap.donate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.donate.model.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

	Optional<List<Comentario>> findByPostagemCodigo (Long postId);
	
	Optional<List<Comentario>> findByUsuarioCodigo (Long userId);
	
	void deleteByPostagemCodigo (Long postId);
	
	void deleteByUsuarioCodigo(Long userId);
	
	
}
