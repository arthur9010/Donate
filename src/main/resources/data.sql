-- USUÁRIO
INSERT INTO TB_DTN_USUARIO (nm_usuario, ds_email, ds_senha, fl_usuario) VALUES
('Laura Martins', 'laura@gmail.com', 'laurinha123', null);

INSERT INTO TB_DTN_USUARIO (nm_usuario, ds_email, ds_senha, fl_usuario) VALUES
('Leonardo Carnetti', 'leonardo@gmail.com', 'leonardo123', null);

INSERT INTO TB_DTN_USUARIO (nm_usuario, ds_email, ds_senha, fl_usuario) VALUES
('Giovana Freitas', 'giovana@gmail.com', 'giovana123', null);


-- POSTAGEM
INSERT INTO TB_DTN_POSTAGEM (fl_postagem, ds_postagem, cd_usuario) VALUES
(null, 'Hoje eu doei meu rim', 1);

INSERT INTO TB_DTN_POSTAGEM (fl_postagem, ds_postagem, cd_usuario) VALUES
(null, 'Doe órgãos pessoal, é importante', 1);

INSERT INTO TB_DTN_POSTAGEM (fl_postagem, ds_postagem, cd_usuario) VALUES
(null, 'Meu sobrinho faleceu e doou todos os órgãos', 2);

INSERT INTO TB_DTN_POSTAGEM (fl_postagem, ds_postagem, cd_usuario) VALUES
(null, 'Saiba como doar', 3);


-- COMENTÁRIO
INSERT INTO TB_DTN_COMENTARIO (ds_comentario, cd_postagem, cd_usuario) VALUES
('Realmente, é muito importante', 2, 2);

INSERT INTO TB_DTN_COMENTARIO (ds_comentario, cd_postagem, cd_usuario) VALUES
('Concordo plenamente', 2, 3);

INSERT INTO TB_DTN_COMENTARIO (ds_comentario, cd_postagem, cd_usuario) VALUES
('Que triste', 3, 3);


-- POSTAGEM FAVORITA
INSERT INTO TB_DTN_POSTAGEM_FAVORITA (cd_postagem, cd_usuario) VALUES
(4, 1);

INSERT INTO TB_DTN_POSTAGEM_FAVORITA (cd_postagem, cd_usuario) VALUES
(2, 1);

INSERT INTO TB_DTN_POSTAGEM_FAVORITA (cd_postagem, cd_usuario) VALUES
(4, 2);


--POSTAGEM REAÇÃO
INSERT INTO TB_DTN_POSTAGEM_REACAO (cd_usuario, cd_postagem) VALUES
(1, 3);

INSERT INTO TB_DTN_POSTAGEM_REACAO (cd_usuario, cd_postagem) VALUES
(1, 4);

INSERT INTO TB_DTN_POSTAGEM_REACAO (cd_usuario, cd_postagem) VALUES
(2, 1);

INSERT INTO TB_DTN_POSTAGEM_REACAO (cd_usuario, cd_postagem) VALUES
(3, 3);

--INSERT INTO TB_DTN_POSTAGEM_REACAO (cd_usuario, cd_postagem) VALUES
--(1, 3);

