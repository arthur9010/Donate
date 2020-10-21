package br.com.fiap.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.donate.model.PostagemFavorita;

public interface PostagemFavoritaRepository extends JpaRepository<PostagemFavorita, Long>{

//	@Modifying
//	@Query("delete from PostagemFavorita pf where pf.usuario = :codigo")
//	void deleteByUsuarioCodigo(@Param("codigo") Long userId);
//	
//	@Modifying
//	@Query("delete from PostagemFavorita pf where pf.postagem = :codigo")
//	void deleteByPostagemCodigo(@Param("codigo") Long postId);
}
