# --- !Ups

create table livro (
  id_livro                  bigint not null,
  titulo                    varchar(255),
  autor                     varchar(255),
  descricao                 varchar(255),
  voto                      integer,
  constraint pk_livro primary key (id_livro))
;

create table usuario (
  id_usuario                bigint not null,
  nome_usuario              varchar(255),
  email_usuario             varchar(255),
  constraint pk_usuario primary key (id_usuario))
;

create sequence livro_seq;

create sequence usuario_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists livro;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists livro_seq;

drop sequence if exists usuario_seq;

