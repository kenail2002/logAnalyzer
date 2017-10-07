CREATE ALIAS IF NOT EXISTS FT_INIT FOR "org.h2.fulltext.FullText.init";
CALL FT_INIT();
CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR);
INSERT INTO TEST VALUES(1, 'Welcome to this world, One_Word');
create table logRecord(id BIGINT ,username varchar(64),password varchar(64),age int);

CALL FT_CREATE_INDEX('PUBLIC', 'TEST', NULL);
