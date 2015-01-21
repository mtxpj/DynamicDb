package com.infosystem.dynamicDatabase.dbStructure;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.dbSchema.DbManager;

public class DbManagerTest {
	@Test
	public void shouldCreateDbProperlyTest() throws SQLException {
		// given
		String dbName = DataForTests.getTestDb();
		// when
		DbManager.createDb(dbName);
		boolean actual = DbManager.ifDbExists(dbName);
		// then
		assertEquals(true, actual);
	}
}
