create database book;
use book;
 create table users (
		id int auto_increment,
        name varchar(30) not null,
        email_id varchar(30) not null,
		password varchar(30) not null,
        active int default 0,
		constraint unique_users_email_id unique(email_id),
		constraint pk_users_id primary key(id)
        );
create table books (
		id int auto_increment,
        name varchar(30) not null,
        price float not null,
        author_name varchar(30) not null,
        constraint pk_books_id primary key(id),
        constraint unique_books_name_author unique(name,author_name)
        );