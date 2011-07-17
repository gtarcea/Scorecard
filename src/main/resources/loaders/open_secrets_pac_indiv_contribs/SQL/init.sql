drop table if exists fdl.PacIndividualContribution;
create table fdl.PacIndividualContribution (
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

