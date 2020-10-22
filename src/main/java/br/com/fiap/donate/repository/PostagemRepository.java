package br.com.fiap.donate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.donate.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	Optional<List<Postagem>> findByUsuarioCodigo (Long userId);
	
	void deleteByUsuarioCodigo(Long userId);
}
	