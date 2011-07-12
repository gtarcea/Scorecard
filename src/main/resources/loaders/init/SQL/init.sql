--
-- Setup the database.
--

drop table if exists fdl.Bill2Representative;
drop table if exists fdl.Bill;
drop table if exists fdl.Representative;
drop table if exists fdl.Pac;
drop table if exists fdl.CRPCategory;

create table fdl.Representative (
	id int AUTO_INCREMENT primary key,
	fecId varchar(12),
	cid varchar(12),
	lastName varchar(64),
	firstName varchar(64),
	party varchar(32),
	districtIdRunFor varchar(8),
	currentDistrictId varchar(8),
	currentlyRunning bool,
	previouslyRan bool,
	candidateType varchar(32),
	noPacs bool,
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

create table fdl.Pac (
	id int AUTO_INCREMENT primary key,
	cycle int,
	pacId varchar(12),
	pacName varchar(48),
	affiliate varchar(48),
	parentOrganization varchar(48),
	recipientId varchar(12),
	pacType varchar(24),
	fecId varchar(12),
	party varchar(32),
	primCode varchar(8),
	primCodeSource varchar(16),
	impactCCommittee bool,
	foreignEntity bool,
    active bool
);

create table fdl.CRPCategory (
	id int AUTO_INCREMENT primary key,
	categoryCode varchar(8),
	categoryName varchar(64),
	categoryOrder varchar(8),
	industry varchar(64),
	sector varchar(64),
	sectorLong varchar(128)
);
