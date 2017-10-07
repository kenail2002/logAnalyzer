CREATE ALIAS IF NOT EXISTS FT_INIT FOR "org.h2.fulltext.FullText.init";
CALL FT_INIT();

create table LOGRECORD(id BIGINT primary key,loglevel varchar(32),
 logTime timestamp,
 threadName varchar(64),
 msg varchar);

CALL FT_CREATE_INDEX('PUBLIC', 'LOGRECORD', NULL);
