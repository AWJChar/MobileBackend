create schema if not exists mobile_app;

drop table if exists mobile_app.users, mobile_app.routes;


CREATE TABLE mobile_app.users (
	email varchar PRIMARY KEY,
	first_name varchar NOT null,
	surname varchar NOT null,
	password varchar NOT null
);

CREATE TABLE mobile_app.routes (
	name varchar NOT NULL PRIMARY KEY,
	user_email varchar NOT null,
	waypoints varchar NOT null,
	FOREIGN KEY (user_email) REFERENCES mobile_app.users(email)
);
