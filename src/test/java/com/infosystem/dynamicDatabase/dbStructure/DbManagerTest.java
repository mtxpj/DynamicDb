package com.infosystem.dynamicDatabase.dbStructure;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.dbSchema.DbManager;

public class DbManagerTest {
	
	@Test
	public void shouldCreateDbProperlyTest() throws SQLException {
		// given
		String dbName = DataForTests.TEST_DB_NAME;
		// when
		DbManager.createDb(dbName);
		boolean actual = DbManager.ifDbExists(dbName);
		// then
		Assert.assertTrue(actual);
	}
}
