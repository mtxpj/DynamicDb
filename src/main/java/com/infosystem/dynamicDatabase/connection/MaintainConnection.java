package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

public class MaintainConnection {

	public static void connect(String DB_NAME) {
		if (ConnectionStatus.connection == null) {
			LocalhostConnector.openConnection(DB_NAME);
		}
	}

	public static void connectLocalhostWithUserAndPassword(String dbName)
			throws SQLException {
		if (ConnectionStatus.connection == null) {
			LocalhostConnector.openConnectionWithUserAndPassword(dbName);
		}
		String conUser = ConnectionStatus.connection.getMetaData()
				.getUserName().toString();
		String expectedUser = LocalhostConnector.USER + "@localhost";
		if (!conUser.equals(expectedUser)) {
			System.out.println("user is not '" + expectedUser + "' but '"
					+ conUser + "'.");
			LocalhostConnector.closeConnection();
			LocalhostConnector.openConnectionWithUserAndPassword(dbName);
		}
	}
}
