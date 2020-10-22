package br.com.fiap.donate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.donate.model.Usuario;
import br.com.fiap.donate.repository.PostagemRepository;
import br.com.fiap.donate.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PostagemRepository postagemRepository; 
//	@Autowired
//	private PostagemFavoritaRepository favoritaRepository;
//	@Autowired
//	private ComentarioRepository comentarioRepository;

	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Long id, Usuario user) {
		Usuario usuario = usuarioRepository.getOne(id);
			
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
		usuario.setFoto(user.getFoto());
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void deleteById(Long userId) {
		while(postagemRepository.findByUsuarioCodigo(userId).isPresent()) {
			postagemRepository.deleteByUsuarioCodigo(userId);
		}
		
		
		//favoritaRepository.deleteByUsuarioCodigo(userId);
		//comentarioRepository.deleteByUsuarioCodigo(userId);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

	-> SELECT * FROM tb_dtn_usuario WHERE cd_usuario=?
	2020-10-22 10:23:48.878 DEBUG 13088 --- [nio-8080-exec-6] org.hibernate.SQL: select usuario0_.cd_usuario as cd_usuar1_3_0_, usuario0_.ds_email as ds_email2_3_0_, usuario0_.fl_usuario as fl_usuar3_3_0_, usuario0_.nm_usuario as nm_usuar4_3_0_, usuario0_.ds_senha as ds_senha5_3_0_ from tb_dtn_usuario usuario0_ where usuario0_.cd_usuario=?
	Hibernate: select usuario0_.cd_usuario as cd_usuar1_3_0_, usuario0_.ds_email as ds_email2_3_0_, usuario0_.fl_usuario as fl_usuar3_3_0_, usuario0_.nm_usuario as nm_usuar4_3_0_, usuario0_.ds_senha as ds_senha5_3_0_ from tb_dtn_usuario usuario0_ where usuario0_.cd_usuario=?
	
	-> SELECT * FROM tb_dtn_postagem p LEFT OUTER JOIN tb_dtn_usuario u ON p.cd_usuario=u.cd_usuario WHERE u.cd_usuario=?
	2020-10-22 10:23:48.897 DEBUG 13088 --- [nio-8080-exec-6] org.hibernate.SQL: select postagem0_.cd_postagem as cd_posta1_1_, postagem0_.ds_postagem as ds_posta2_1_, postagem0_.cd_usuario as cd_usuar3_1_ from tb_dtn_postagem postagem0_ left outer join tb_dtn_usuario usuario1_ on postagem0_.cd_usuario=usuario1_.cd_usuario where usuario1_.cd_usuario=?
	Hibernate: select postagem0_.cd_postagem as cd_posta1_1_, postagem0_.ds_postagem as ds_posta2_1_, postagem0_.cd_usuario as cd_usuar3_1_ from tb_dtn_postagem postagem0_ left outer join tb_dtn_usuario usuario1_ on postagem0_.cd_usuario=usuario1_.cd_usuario where usuario1_.cd_usuario=?
	
	-> SELECT * FROM tb_dtn_postagem p LEFT OUTER JOIN tb_dtn_usuario u ON p.cd_usuario=u.cd_usuario WHERE u.cd_usuario=?
	2020-10-22 10:23:49.233 DEBUG 13088 --- [nio-8080-exec-6] org.hibernate.SQL: select postagem0_.cd_postagem as cd_posta1_1_, postagem0_.ds_postagem as ds_posta2_1_, postagem0_.cd_usuario as cd_usuar3_1_ from tb_dtn_postagem postagem0_ left outer join tb_dtn_usuario usuario1_ on postagem0_.cd_usuario=usuario1_.cd_usuario where usuario1_.cd_usuario=?
	Hibernate: select postagem0_.cd_postagem as cd_posta1_1_, postagem0_.ds_postagem as ds_posta2_1_, postagem0_.cd_usuario as cd_usuar3_1_ from tb_dtn_postagem postagem0_ left outer join tb_dtn_usuario usuario1_ on postagem0_.cd_usuario=usuario1_.cd_usuario where usuario1_.cd_usuario=?
	
	-> DELETE FROM tb_dtn_postagem WHERE cd_postagem=?
	2020-10-22 10:23:49.250 DEBUG 13088 --- [nio-8080-exec-6] org.hibernate.SQL: delete from tb_dtn_postagem where cd_postagem=?
	Hibernate: delete from tb_dtn_postagem where cd_postagem=?
	
	-> DELETE FROM tb_dtn_usuario WHERE cd_usuario=?
	2020-10-22 10:23:49.267 DEBUG 13088 --- [nio-8080-exec-6] org.hibernate.SQL: delete from tb_dtn_usuario where cd_usuario=?
	Hibernate: delete from tb_dtn_usuario where cd_usuario=?
	*/