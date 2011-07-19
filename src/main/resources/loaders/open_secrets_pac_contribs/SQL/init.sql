drop table if exists fdl.PacContribution;
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

