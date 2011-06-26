--
-- Setup the database.
--

drop table if exists fdl.Bill2Representative;
drop table if exists fdl.Bill;
drop table if exists fdl.Representative;

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

