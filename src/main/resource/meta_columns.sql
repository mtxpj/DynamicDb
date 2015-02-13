CREATE TABLE all_columns ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)    ,
	column_order		 int	,
	column_definition    bool   DEFAULT false ,
	html_label           varchar(255)    ,
	plain_label          varchar(255)    ,
	data_type            varchar(20)  NOT NULL  ,
	tables_id       	 int  NOT NULL  ,
	CONSTRAINT pk_meta_columns PRIMARY KEY ( id )
 ) engine=InnoDB;