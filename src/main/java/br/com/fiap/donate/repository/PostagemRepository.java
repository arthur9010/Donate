package br.com.fiap.donate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.donate.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	Optional<List<Postagem>> findByUsuarioCodigo (Long userId);
	
//	@Modifying
//	@Query("delete from Postagem p WHERE p.usuario =:codigo")
//	void deleteByUsuarioCodigo(@Param("codigo") Long userId);
	
	void deleteByUsuarioCodigo(Long userId);
}
	