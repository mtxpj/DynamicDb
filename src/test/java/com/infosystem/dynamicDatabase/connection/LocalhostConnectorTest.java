package com.infosystem.dynamicDatabase.connection;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;

public class LocalhostConnectorTest {

	private static final String WRONG_DB_NAME = "wrong db name";

	@Test
	public void testOpenConnection() {
		LocalhostConnector.openConnection(DataForTests.getLocalhost());
		String actual = null;
		String expected = null;
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void shouldNotConnectToDb() {
		LocalhostConnector.openConnection(WRONG_DB_NAME);
	}

	@Ignore
	@Test
	public void testCloseConnection() {
		fail("Not yet implemented");
	}
}
