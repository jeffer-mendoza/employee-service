create table employee
(
	id bigint not null primary key,
	base_salary float null,
	date_end datetime null,
	date_start datetime null,
	firstname varchar(255) null,
	lastname varchar(255) null
)

INSERT INTO employee (id, base_salary, date_end, date_start, firstname, lastname)
VALUES (1, 1000000, '2018-11-25 00:00:00', '2018-08-12 00:00:00', 'Juan c', 'Gonzalez');

