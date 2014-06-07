# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table livro (
  id_livro                  bigint not null,
  titulo                    varchar(255),
  autor                     varchar(255),
  descricao                 varchar(255),
  voto                      integer,
  constraint pk_livro primary key (id_livro))
;

create sequence livro_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists livro;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists livro_seq;

