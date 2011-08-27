drop table if exists fdl.Committee527Income;
create table fdl.Committee527Income (
	id int AUTO_INCREMENT primary key,
	reportingQuarter int,
	reportingYear int,
	organizationName varchar(48),
	amount decimal(10,2)
);