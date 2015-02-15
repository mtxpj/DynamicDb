package com.infosystem.dynamicDatabase.tablesTableSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;

public class DbManagerSqlQueryTest {

	@Test
	public void shouldProperlyReturnCreateDbQuery() {
		// given
		String expected = "CREATE DATABASE tdd_db;";
		// when
		String actual = DbManagerSqlQuery.createDb(DataForTests.TEST_DB_NAME);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDb() {
		// given
		String actual = "DROP DATABASE tdd_db;";
		// when
		String expected = DbManagerSqlQuery.dropDb(DataForTests.TEST_DB_NAME);
		// then
		Assert.assertEquals(expected, actual);
	}

}
