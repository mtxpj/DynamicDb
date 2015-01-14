package com.infosystem.dynamicDatabase.dbMetadata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DbManagerTest {
	@Test
	public void shouldCreateDbProperlyTest() {
		// given
		String dbName = Metadata.getTestDb();
		// when
		DbManager.createDb(dbName);
		boolean actual = DbManager.ifDbExists(dbName);
		// then
		assertEquals(true, actual);
	}
}
