package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;
import com.infosystem.dynamicDatabase.dbMetadata.Metadata;

public class DbManagerSqlQueryTest {

	@Test
	public void shouldProperlyReturnCreateDbQuery() {
		// given
		String expected = "CREATE DATABASE tdd_db;";
		// when
		String actual = DbManagerSqlQuery.createDb(Metadata.getTestDb());
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDeleteDb() {
		// given
		String actual = "DROP DATABASE tdd_db;";
		// when
		String expected = DbManagerSqlQuery.dropDb(Metadata.getTestDb());
		// then
		Assert.assertEquals(expected, actual);
	}

}
