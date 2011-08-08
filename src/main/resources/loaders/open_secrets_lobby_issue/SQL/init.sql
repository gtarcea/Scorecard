drop table if exists fdl.LobbyIssue;
create table fdl.LobbyIssue(
	id int AUTO_INCREMENT primary key,
	osId int,
	soprId varchar(48),
	issueAreaCategory varchar(3),
	issueAreaDescription varchar(64),
	specificIssue text,
	year int
);