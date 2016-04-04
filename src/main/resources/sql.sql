create database if not exists userProfile;

drop table if exists userProfile.profile;

create table userProfile.profile (id varchar(50) primary key, firstname varchar(50), lastname varchar(50), email varchar(50), address varchar(50), organization varchar (50), aboutmyself varchar(100));

insert into userProfile.profile(id, firstname, lastname) values ('1001', 'chenglong', 'wei');