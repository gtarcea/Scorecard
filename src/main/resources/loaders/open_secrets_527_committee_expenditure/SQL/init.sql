drop table if exists fdl.Committee527Expenditure;
create table fdl.Committee527Expenditure (
	id int AUTO_INCREMENT primary key,
	reportingQuarter int,
	reportingYear int,
	orgName varchar(128),
	ein varchar(12),
	recipient varchar(64),
	recipientCrp varchar(64),
	amount decimal(10,2),
	expenditureDate date,
	expenditureCode varchar(8),
	expenditurePurpose text
);