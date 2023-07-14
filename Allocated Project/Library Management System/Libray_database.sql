create database Library;
use Library;
show tables;


create table Admin (username varchar(50), password varchar(50));

show tables;

desc admin;

insert into admin values('admin','admin');

select * from admin;

create table librarian 
(Lid int primary key not null auto_increment, name varchar(50), password varchar(50), 
email varchar(50), contact varchar(50), address varchar(50), city varchar(50));

show tables;


desc librarian;

select * from librarian;

create table addbook (id int primary key not null auto_increment, Bookno varchar(50),
 Bookname varchar(50), Author varchar(50), Publisher varchar(50), Quantity int, 
 Issuebook int default 0, date varchar(50));

desc addbook;

select * from addbook;

SET SQL_SAFE_UPDATES = 0;

update addbook
set Bookno='j@va'
where Bookno='1';

SET SQL_SAFE_UPDATES = 1;

create table issuebook(BookId varchar(50), Bookno varchar(50),
 Bookname varchar(50), StudentId varchar(50), Studentname varchar(50), Studentcontact varchar(50),
 Date varchar(50));
 
 select * from issuebook;
 
 delete from issuebook where BookId='2';
 
  delete from addbook where id in ('1','2','3');
 