--
-- Setup the database.
--

drop table if exists fdl.Bill2Representative;
drop table if exists fdl.Bill;
drop table if exists fdl.Representative;
drop table if exists fdl.Pac;
drop table if exists fdl.CRPCategory;
drop table if exists fdl.PacCandidateContribution;
drop table if exists fdl.PacContribution;
drop table if exists fdl.IndustryLobbying;
drop table if exists fdl.LobbyIssue;
drop table if exists fdl.Lobbyist;

drop table if exists fdl.Chamber;

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

create table fdl.PacCandidateContribution (
	id int AUTO_INCREMENT primary key,
	cycle int,
	fecTransactionId varchar(16),
	cid varchar(12),
	pacId varchar(12),
	amount decimal(10,2),
	contribDate date,
	primCode varchar(8),
	contributionType varchar(48),
	directContribution bool,
	fecCandidateId varchar(12)
);

create table fdl.PacContribution (
	id int AUTO_INCREMENT primary key,
	cycle int,
	fecTransactionId varchar(16),
	pacId varchar(12),
	donorPac varchar(48),
	reportedName varchar(48),
	reportedEmployer varchar(48),
	primCode varchar(8),
	contribDate date,
	amount decimal(10,2),
	recipientId varchar(12),
	party varchar(32),
	committeeId varchar(12),
	recipientType varchar(24),
	recipientParty varchar(32),
	recipientPacType varchar(24),
	recipientPrimCode varchar(8),
	amendedReport bool,
	reportType varchar(8),
	generalElectionContrib bool,
	contributionType varchar(48),
	realCode varchar(8)
);

create table fdl.Chamber (
	id int AUTO_INCREMENT primary key,
	chamber varchar(8)
);

insert into fdl.Chamber(chamber) select 'SENATE';
insert into fdl.Chamber(chamber) select 'HOUSE';

create table fdl.CongressionalCommittee (
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	chamberId int foreign key references fdl.Chamber(id)
);

create table fdl.IndustryLobbying(
	id int AUTO_INCREMENT primary key,
	parentCompany varchar(48),
	clientName varchar(48),
	totalAmount decimal(12,2),
	crpCategory varchar(8),
	year int
);

create table fdl.LobbyIssue(
	id int AUTO_INCREMENT primary key,
	osId int,
	soprId varchar(48),
	issueAreaCategory varchar(3),
	issueAreaDescription varchar(64),
	specificIssue text,
	year int
);

create table fdl.Lobbyist(
	id int AUTO_INCREMENT primary key,
	soprId varchar(48),
	lobbyistNameRaw varchar(64),
	lobbyistNameStandardized varchar(64),
	lobbyistId varchar(16),
	year int,
	previousGovernmentPosition varchar(255),
	cid varchar(16),
	formerMemberOfCongress bool
);
