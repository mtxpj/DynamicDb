package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

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
		String actual = DbManagerSqlQuery.createDb(DataForTests.getTestDb());
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDb() {
		// given
		String actual = "DROP DATABASE tdd_db;";
		// when
		String expected = DbManagerSqlQuery.dropDb(DataForTests.getTestDb());
		// then
		Assert.assertEquals(expected, actual);
	}

}
