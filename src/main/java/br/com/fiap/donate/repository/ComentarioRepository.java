package br.com.fiap.donate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.donate.model.Comentario;
import br.com.fiap.donate.model.Postagem;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

	Optional<List<Comentario>> findByPostagemCodigo (Long postId);
	
	//	@Modifying
//	@Query("delete from Comentario c where c.usuario = :codigo")
//	void deleteByUsuarioCodigo(@Param("codigo") Long userId);
//	
//	@Modifying
//	@Query("delete from Comentario c where c.postagem = :codigo")
//	void deleteByPostagemCodigo(@Param("codigo") Long postId);
}
