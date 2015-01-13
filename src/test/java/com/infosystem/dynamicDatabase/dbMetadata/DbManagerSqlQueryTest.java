package com.infosystem.dynamicDatabase.dbMetadata;

import org.junit.Assert;
import org.junit.Test;

public class DbManagerSqlQueryTest {

	private static final String TEST_DB = "tdd_db";
	private static final String TABLES_TABLE_NAME = "meta_tables";

	@Test
	public void shouldProperlyReturnCreateDbQuery() {
		// given
		String actual = "CREATE DATABASE tdd_db;";
		// when
		String expected = DbManagerSqlQuery.createDb(TEST_DB);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDb() {
		// given
		String actual = "DROP DATABASE tdd_db;";
		// when
		String expected = DbManagerSqlQuery.dropDb(TEST_DB);
		// then
		Assert.assertEquals(expected, actual);
	}

}
