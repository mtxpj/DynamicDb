ALTER TABLE all_columns ADD CONSTRAINT fk_all_columns_all_tables FOREIGN KEY ( tables_id ) REFERENCES all_tables( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;