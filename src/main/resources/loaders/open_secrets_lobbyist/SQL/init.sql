drop table if exists fdl.Lobbyist;
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