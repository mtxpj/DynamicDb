package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;

public class LocalhostConnectorTest {

	private static final String WRONG_DB_NAME = "'wrong db name, wrong as shit'";

	@Test
	public void testOpenConnection() throws SQLException {
		// given
		boolean expected = true;
		boolean actual;
		// when
		LocalhostConnector.openConnectionWithUserAndPassword(DataForTests
				.getTestDb());
		actual = ConnectionStatus.connection.isValid(0);
		// than
		Assert.assertEquals(expected, actual);
		ConnectionStatus.connection.close();
	}

	@Test
	public void shouldNotConnectToDb() throws SQLException {
		// given
		boolean expected = false;
		boolean actual;
		// when
		LocalhostConnector.openConnection(WRONG_DB_NAME);
		actual = ConnectionStatus.connection.isValid(0);
		// than
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCloseConnection() throws SQLException {
		// given
		boolean closed;
		boolean connected;
		// when
		LocalhostConnector.openConnectionWithUserAndPassword(DataForTests
				.getTestDb());
		connected = ConnectionStatus.connection.isValid(0);
		LocalhostConnector.closeConnection();
		closed = ConnectionStatus.connection.isValid(0);
		// than
		Assert.assertNotEquals(closed, connected);
	}
}
