
drop table if exists fdl.LdaLobbyFiling2GovernmentEntity;
drop table if exists fdl.LdaGovernmentEntity;
drop table if exists fdl.LdaLobbyFiling2ForeignEntity;
drop table if exists fdl.LdaForeignEntity;
drop table if exists fdl.LdaLobbyFiling2LdaLobbyist;
drop table if exists fdl.LdaLobbyist;
drop table if exists fdl.LdaLobbyFiling2LdaLobbyIssue;
drop table if exists fdl.LdaLobbyIssue;
drop table if exists fdl.LdaLobbyingFiling;
drop table if exists fdl.LdaLobbyingClient;
drop table if exists fdl.LdaLobbyingRegistrant;


create table fdl.LdaLobbyRegistrant(
	id int AUTO_INCREMENT primary key,
	registrantId int,
	name varchar(128),
	description text,
	address varchar(256),
	country varchar(32),
	ppbCountry varchar(32)
);


create table fdl.LdaLobbyingClient(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	description text,
	clientId int,
	status varchar(32),
	contactName varchar(64),
	stateOrLocalGovernment bool,
	country varchar(32),
	ppbCountry varchar(32),
	state varchar(32),
	ppbState varchar(32)
);


create table fdl.LdaLobbyFiling(
	id int AUTO_INCREMENT primary key,
	filingId varchar(64),
	year int,
	amount decimal(12,2),
	ltype varchar,
	registrantId int foreign key references fdl.LdaLobbyingRegistrant(id),
	clientId int foreign key references fdl.LdaLobbyingClient(id)
);

create table fdl.LdaGovernmentEntity(
	id int AUTO_INCREMENT primary key,
	name varchar(128)
);

create table fdl.LdaLobbyFiling2GovernmentEntity(
	lobbyFilingId int foreign key references fdl.LdaLobbyFiling(id),
	governmentEntityId int foreign key references fdl.LdaGovernmentEntity(id)
);

create table fdl.LdaForeignEntity(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	country varchar(64),
	ppbCountry varchar(64),
	ownershipPercentage int,
	status varchar(8)
);

create table fdl.LdaLobbyFiling2ForeignEntity(
	lobbyFilingId int foreign key references fdl.LdaLobbyFiling(id),
	foreignEntityId int foreign key references fdl.LdaForeignEntity(id)
);

create table fdl.LdaLobbyist(
	id int AUTO_INCREMENT primary key,
	name varchar(128),
	status varchar(8),
	indicator varchar(8),
	officialPosition varchar(256)
);

create table fdl.LdaLobbyFiling2LdaLobbyist(
	lobbyFilingId int foreign key references fdl.LdaLobbyFiling(id),
	lobbyistId int foreign key references fdl.LdaLobbyist(id)
);

create table fdl.LdaLobbyIssue(
	id int AUTO_INCREMENT primary key,
	code varchar(256),
	specificIssue text
);

create table fdl.LdaLobbyFiling2LdaLobbyIssue(
	lobbyFilingId int foreign key references fdl.LdaLobbyFiling(id),
	lobbyIssueId int foreign key references fdl.LdaLobbyFiling(id),
);
