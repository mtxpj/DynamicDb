package com.infosystem.dynamicDatabase.connection;

import static com.infosystem.dynamicDatabase.DataForTests.DataForTests.TEST_DB_NAME;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class LocalhostConnectorTest {

	private static final String WRONG_DB_NAME = "'wrong db name'";

	@Test
	public void shouldConnectToDbTest() throws SQLException {
		// given
		// when
		LocalhostConnector.openConnection(TEST_DB_NAME);

		// than
		Assert.assertNotNull(ConnectionStatus.getInstance().getConnection());
	}

	@Test
	public void shouldNotConnectToDbTest() throws SQLException {
		// given
		// when
		LocalhostConnector.openConnection(WRONG_DB_NAME);
		// then
		Assert.assertNull(ConnectionStatus.getInstance().getConnection());
	}

	@Test
	public void shouldCloseConnectionTest() throws SQLException {
		// given
		boolean closed;
		boolean connected;
		// when
		LocalhostConnector.openConnection(TEST_DB_NAME);
		connected = ConnectionStatus.getInstance().getConnection().isValid(0);
		LocalhostConnector.closeConnection();
		closed = ConnectionStatus.getInstance().getConnection().isValid(0);
		// than
		Assert.assertNotEquals(closed, connected);
	}
}
