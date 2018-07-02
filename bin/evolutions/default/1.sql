# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ebean_proposal (
  uuid                          uuid not null,
  name                          varchar(255),
  description                   varchar(255),
  date                          timestamp,
  udate                         timestamp,
  rank                          integer,
  constraint pk_ebean_proposal primary key (uuid)
);


# --- !Downs

drop table if exists ebean_proposal;

