drop table if exists fdl.IndustryLobbying;
create table fdl.IndustryLobbying(
	id int AUTO_INCREMENT primary key,
	parentCompany varchar(48),
	clientName varchar(48),
	totalAmount decimal(12,2),
	crpCategory varchar(8),
	year int
);