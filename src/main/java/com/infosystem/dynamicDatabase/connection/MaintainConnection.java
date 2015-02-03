package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class MaintainConnection {

	public static void connect(String DB_NAME) {
		if (ConnectionStatus.getInstance().getConnection() == null) {
			LocalhostConnector.openConnection(DB_NAME);
		}
	}

	public static void connectLocalhostWithUserAndPassword(String dbName)
			throws SQLException {
		if (ConnectionStatus.getInstance().getConnection() == null) {
			LocalhostConnector.openConnectionWithUserAndPassword(dbName);
		}
		String conUser = ConnectionStatus.getInstance().getConnection()
				.getMetaData().getUserName().toString();
		String expectedUser = ConnectorData.USER + "@localhost";
		if (!conUser.equals(expectedUser)) {
			System.out.println("user is not '" + expectedUser + "' but '"
					+ conUser + "'.");
			LocalhostConnector.closeConnection();
			LocalhostConnector.openConnectionWithUserAndPassword(dbName);
		}
	}
}
