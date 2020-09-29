package br.com.fiap.donate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.donate.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

}
