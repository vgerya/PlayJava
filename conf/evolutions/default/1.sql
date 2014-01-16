# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table proporsal (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  proporsal                 varchar(1000),
  type                      integer,
  is_approved               tinyint(1) default 0,
  keywords                  varchar(255),
  speaker_id                bigint,
  constraint ck_proporsal_type check (type in (0,1)),
  constraint pk_proporsal primary key (id))
;

create table speaker (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  bio                       varchar(1000),
  twitter_id                varchar(255),
  picture_url               varchar(255),
  constraint pk_speaker primary key (id))
;

alter table proporsal add constraint fk_proporsal_speaker_1 foreign key (speaker_id) references speaker (id) on delete restrict on update restrict;
create index ix_proporsal_speaker_1 on proporsal (speaker_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table proporsal;

drop table speaker;

SET FOREIGN_KEY_CHECKS=1;

