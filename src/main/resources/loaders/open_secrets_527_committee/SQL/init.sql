drop table if exists fdl.Committee527;

create table fdl.Committee527 (
	id int AUTO_INCREMENT primary key,
	cycle int,
	reportingQuarter int,
	reportingYear int,
	ein varchar(12),
	name varchar(48),
	affiliate varchar(48),
	parentOrganization varchar(48),
	pacType varchar(24),
	fecId varchar(12),
	party varchar(32),
	primCode varchar(8),
	primCodeSource varchar(16),
	filingFrequency varchar(12),
	committeeType varchar(8),
	committeeTypeSource varchar(8),
	ideology varchar(16),
	comments text,
	organizationState varchar(4)
);