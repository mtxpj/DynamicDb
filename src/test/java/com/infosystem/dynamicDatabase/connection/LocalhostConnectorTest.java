package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;

public class LocalhostConnectorTest {

	private static final String WRONG_DB_NAME = "'wrong db name, wrong as shit'";

	@Test
	public void shouldConnectToDbTest() throws SQLException {
		// given
		boolean expected = true;
		boolean actual;
		// when
		LocalhostConnector.openConnectionWithUserAndPassword(DataForTests
				.getTestDb());
		actual = ConnectionStatus.getInstance().getConnection().isValid(0);
		// than
		Assert.assertEquals(expected, actual);
		ConnectionStatus.getInstance().getConnection().close();
	}

	@Test
	public void shouldNotConnectToDbTest() throws SQLException {
		// given
		// when
		LocalhostConnector.openConnectionWithUserAndPassword(WRONG_DB_NAME);
		// then
		Assert.assertNull(ConnectionStatus.getInstance().getConnection());
	}

	@Test
	public void shouldCloseConnectionTest() throws SQLException {
		// given
		boolean closed;
		boolean connected;
		// when
		LocalhostConnector.openConnectionWithUserAndPassword(DataForTests
				.getTestDb());
		connected = ConnectionStatus.getInstance().getConnection().isValid(0);
		LocalhostConnector.closeConnection();
		closed = ConnectionStatus.getInstance().getConnection().isValid(0);
		// than
		Assert.assertNotEquals(closed, connected);
	}
}
