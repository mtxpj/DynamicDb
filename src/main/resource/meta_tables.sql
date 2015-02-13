CREATE TABLE all_tables ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	name                 varchar(100),
	CONSTRAINT pk_meta_tables PRIMARY KEY ( id )
 ) engine=InnoDB;