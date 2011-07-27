
drop table if exists fdl.Bill;

create table fdl.Bill (
	id int AUTO_INCREMENT primary key,
	chamber varchar(64),
	title varchar(1024)
);