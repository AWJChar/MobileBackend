create schema if not exists mobile_app;

drop table if exists mobile_app.users;

create table mobile_app.users (
	email varchar primary key,
	first_name varchar not null,
	surname varchar not null,
	password varchar not null
);

INSERT INTO mobile_app.users
(email, first_name, surname, password)
VALUES('joe@gmail.net', 'Joe', 'Bloggs', 'Password1');

INSERT INTO mobile_app.users
(email, first_name, surname, password)
VALUES('tom@gmail.net', 'Tom', 'Cat', 'Password1');

INSERT INTO mobile_app.users
(email, first_name, surname, password)
VALUES('jerry@gmail.net', 'Jerry', 'Mouse', 'Password1');
