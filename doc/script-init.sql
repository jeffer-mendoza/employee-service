create table employee
(
    id bigint not null,
    base_salary float not null,
    date_end datetime(6) null,
    date_start datetime(6) null,
    firstname varchar(255) null,
    lastname varchar(255) null,
    primary key ()
);
