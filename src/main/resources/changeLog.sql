--liquibase formatted sql
--changeset tanvir:1
create table department(
 id int auto_increment not null,
 name varchar(100) not null,
 active bit(1) not null default true,
 primary key(id)
);

--changeset tanvir:2
insert into department (name,active) values ('Robert Bruise', true);
insert into department (name,active) values ('Nathan Tital', true);

--changeset farhan:3
update department set name='Alex roddin' where name='Nathan Tital';

--changeset Robin Hood:4
alter table department add phone varchar(20);

--changeset Tanvir:55
delete from department where name='Alex roddin';

--changeset welldev:1000
alter table department drop column active;