package com.infosystem.dynamicDatabase.DataForTests;

import static com.infosystem.dynamicDatabase.connection.ConnectionStatus.statement;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class SqlQueryForTests {
	@BeforeClass
	public static void createDbs() throws SQLException {
		final String CREATE_DB = "CREATE DATABASE " + DataForTests.getTestDb()
				+ ";";
		final String DROP_DB = "DROP DATABASE " + DataForTests.getTestDb()
				+ ";";
		final String USE_DB = "USE " + DataForTests.getTestDb();

		final String CREATE_BOOLEAN_TABLE = "CREATE TABLE boolean"
				+ "(\nb_id INT NOT NULL AUTO_INCREMENT,\n"
				+ "options VARCHAR(5) NOT NULL,\n"
				+ "PRIMARY KEY ( b_id )\n) DEFAULT CHARSET=utf8;";
		final String FILL_BOOLEAN_DB = "INSERT INTO boolean (options)\n"
				+ "VALUES (\"true\"),(\"false\");";

		final String CREATE_DATATYPES_TABLE = "CREATE TABLE data_types"
				+ "(\ndt_id INT NOT NULL AUTO_INCREMENT,\n"
				+ "value VARCHAR(16) NOT NULL,\n"
				+ "PRIMARY KEY ( dt_id )\n) DEFAULT CHARSET=utf8;";
		final String FILL_DATATYPES_DB = "INSERT INTO data_types (value)\n"
				+ "VALUES (\"STRING\"),(\"DATE\"),(\"NUMBER\"),(\"PREDEFINED_VALUE\"),(\"SUB_SET\");";

		final String CREATE_TABLE_STORING_TABLES = "CREATE TABLE "
				+ DataForTests.getTablesTableName()
				+ "(\nt_id INT NOT NULL AUTO_INCREMENT,\n"
				+ "table_id VARCHAR(100) NOT NULL,\n"
				+ "PRIMARY KEY ( t_id )\n) DEFAULT CHARSET=utf8;";

		final String CREATE_TABLE_STORING_COLUMNS = "CREATE TABLE "
				+ DataForTests.getColumnsTableName()
				+ "(\nc_id INT NOT NULL AUTO_INCREMENT,\n" + "t_id INT,\n"
				+ "id VARCHAR(100) NOT NULL,\n"
				+ "column_order INT(2) NOT NULL,\n"
				+ "column_definition VARCHAR(100) NOT NULL,\n"
				+ "html_label VARCHAR(255) NOT NULL,\n"
				+ "plain_label VARCHAR(255) NOT NULL,\n" + "data_type INT,\n"
				+ "PRIMARY KEY ( c_id ),\n"
				+ "FOREIGN KEY ( t_id ) REFERENCES all_tables(t_id),\n"
				+ "FOREIGN KEY ( data_type ) REFERENCES data_types(dt_id)\n)"
				+ " DEFAULT CHARSET=utf8;";

		MaintainConnection.connectLocalhostWithUserAndPassword(DataForTests
				.getTestDb());
		statement.executeUpdate(DROP_DB);
		statement.executeUpdate(CREATE_DB);
		statement.executeUpdate(USE_DB);
		statement.executeUpdate(CREATE_BOOLEAN_TABLE);
		statement.executeUpdate(CREATE_DATATYPES_TABLE);
		statement.executeUpdate(CREATE_TABLE_STORING_TABLES);
		statement.executeUpdate(CREATE_TABLE_STORING_COLUMNS);

		statement.executeUpdate(FILL_BOOLEAN_DB);
		statement.executeUpdate(FILL_DATATYPES_DB);
	}

	@Ignore
	@Test
	public void createNewTableTest() {
		// create example filling
		final String CREATE_PERSONS_TABLE = "CREATE TABLE persons"
				+ "(\np_id INT NOT NULL AUTO_INCREMENT,\n"
				+ "name VARCHAR(20) NOT NULL,\n"
				+ "surname VARCHAR(20) NOT NULL,\n" + "date_of_birth DATE,\n"
				+ "e_id INT,\n" + "weight INT(3) NOT NULL,\n"
				+ "PRIMARY KEY ( p_id ),\n"
				+ "FOREIGN KEY ( e_id ) REFERENCES employer(e_id)\n);";

		final String FILL_TABLE = ";";
	}

	@AfterClass
	public static void after() throws SQLException {
		ConnectionStatus.connection.close();
	}
}
