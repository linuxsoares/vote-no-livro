# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table livros (
  id                        bigint not null,
  titulo                    varchar(255),
  autor                     varchar(255),
  descricao                 varchar(255),
  voto                      integer,
  constraint pk_livros primary key (id))
;

create sequence livros_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists livros;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists livros_seq;

