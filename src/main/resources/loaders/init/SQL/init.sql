--
-- Setup the database.
--

drop table if exists fdl.Bill2Representative;
drop table if exists fdl.Bill;
drop table if exists fdl.Representative;

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
    billid int not null,
    representativeid int not null,
	foreign key (billid) references fdl.Bill(id),
	foreign key (representativeid) references fdl.Representative(id)
);

