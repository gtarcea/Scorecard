
drop table if exists fdl.LdaLobbyFiling2GovernmentEntity;
drop table if exists fdl.LdaGovernmentEntity;
drop table if exists fdl.LdaLobbyFiling2ForeignEntity;
drop table if exists fdl.LdaForeignEntity;
drop table if exists fdl.LdaLobbyFiling2LdaLobbyist;
drop table if exists fdl.LdaLobbyist;
drop table if exists fdl.LdaLobbyFiling2LdaLobbyIssue;
drop table if exists fdl.LdaLobbyIssue;
drop table if exists fdl.LdaLobbyFiling;
drop table if exists fdl.LdaLobbyClient;
drop table if exists fdl.LdaLobbyRegistrant;


create table fdl.LdaLobbyRegistrant(
	id int AUTO_INCREMENT primary key,
	registrantId int,
	name varchar(128),
	description text,
	address varchar(256),
	country varchar(64),
	ppbCountry varchar(64)
);

create table fdl.LdaLobbyClient(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	description text,
	clientId int,
	status varchar(32),
	contactName varchar(64),
	stateOrLocalGovernment bool,
	country varchar(64),
	ppbCountry varchar(64),
	state varchar(32),
	ppbState varchar(32)
);

create table fdl.LdaLobbyFiling(
	id int AUTO_INCREMENT primary key,
	filingId varchar(64),
	year int,
	received varchar(32),
	amount double(12,2),
	ltype varchar(64),
	period varchar(64),
	registrantId int,
	foreign key (registrantId) references fdl.LdaLobbyRegistrant(id) on delete cascade,
	clientId int null,
	foreign key (clientId) references fdl.LdaLobbyClient(id) on delete cascade
);

create table fdl.LdaGovernmentEntity(
	id int AUTO_INCREMENT primary key,
	name varchar(128)
);

create table fdl.LdaLobbyFiling2GovernmentEntity(
	lobbyFilingId int,
	foreign key (lobbyFilingId) references fdl.LdaLobbyFiling(id) on delete cascade,
	governmentEntityId int,
	foreign key (governmentEntityId) references fdl.LdaGovernmentEntity(id) on delete cascade
);

create table fdl.LdaForeignEntity(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	country varchar(64),
	ppbCountry varchar(64),
	foreignOwnershipPercentage int,
	status varchar(8)
);

create table fdl.LdaLobbyFiling2ForeignEntity(
	lobbyFilingId int,
	foreign key (lobbyFilingId) references fdl.LdaLobbyFiling(id) on delete cascade,
	foreignEntityId int,
	foreign key (foreignEntityId) references fdl.LdaForeignEntity(id) on delete cascade
);

create table fdl.LdaLobbyist(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	status varchar(8),
	indicator varchar(8),
	officialPosition varchar(256)
);

create table fdl.LdaLobbyFiling2LdaLobbyist(
	lobbyFilingId int,
	foreign key (lobbyFilingId) references fdl.LdaLobbyFiling(id) on delete cascade,
	lobbyistId int,
	foreign key (lobbyistId) references fdl.LdaLobbyist(id) on delete cascade
);

create table fdl.LdaLobbyIssue(
	id int AUTO_INCREMENT primary key,
	code varchar(256),
	specificIssue text
);

create table fdl.LdaLobbyFiling2LdaLobbyIssue(
	lobbyFilingId int,
	foreign key (lobbyFilingId) references fdl.LdaLobbyFiling(id) on delete cascade,
	lobbyIssueId int,
	foreign key (lobbyIssueId) references fdl.LdaLobbyIssue(id) on delete cascade
);
