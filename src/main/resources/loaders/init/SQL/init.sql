--
-- Initializes the database.
--
drop table if exists fdl.Representative;
drop table if exists fdl.Bill;

create table fdl.Representative (
	id int AUTO_INCREMENT primary key,
	lastName varchar(64),
	firstName varchar(64),
	committee varchar(64)
);

create table fdl.Bill (
	id int AUTO_INCREMENT primary key,
	chamber varchar(64),
	title varchar(1024)
);

create table fdl.Bill2Representative (
	billid int foreign key references Bill(id),
	representativeid int foreign key references Representative(id)
);

