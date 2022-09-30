CREATE SCHEMA voto;

CREATE TABLE voto.candidato
(
  id bigserial NOT NULL PRIMARY KEY,
  numero integer NOT NULL UNIQUE,
  nome character varying(100),
  imagem text
);

CREATE TABLE voto.usuario
(
  id bigserial NOT NULL PRIMARY KEY,
  voto integer NOT NULL,
  idade integer NOT NULL,
  cidade character varying(100),
  estado character varying(100),
  FOREIGN KEY (voto) REFERENCES voto.candidato (numero)
);

insert into voto.candidato (id, numero, nome, imagem) values (default, 12, 'Ciro Gomes (PDT)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001612393_div_j9D1MF6.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 27, 'Constituinte Eymael (DC)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001677435_div_IU3ujNQ.jpeg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 30, 'Felipe D Ávila (NOVO)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001603612_div_biJ2C22.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 22, 'Jair Bolsonaro (PL)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001618036_div_epUr2l0.jpeg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 80, 'Léo Péricles (UP)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001602702_div_7axrl2m.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 13, 'Lula (PT)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001607829_div_S5eZkgY.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 90, 'Pablo Marçal (PROS)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001600179_div_Gp7zpgv.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 14, 'Padre Kelmon (PTB)', 'https://eleicoes.poder360.com.br/media/fotos/foto_WEcockF.jpeg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 15, 'Simone Tebet (MDB)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001607833_div_PUpUoWf.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 21, 'Sofia Manzano (PCB)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001600167_div_2Kculr7.jpeg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 44, 'Soraya Thronicke (UNIÃO)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001644128_div_xYpzp57.jpg');
insert into voto.candidato (id, numero, nome, imagem) values (default, 16, 'Vera Lúcia (PSTU)', 'https://eleicoes.poder360.com.br/media/fotos/FBR280001607831_div_EiRh1K2.jpg');