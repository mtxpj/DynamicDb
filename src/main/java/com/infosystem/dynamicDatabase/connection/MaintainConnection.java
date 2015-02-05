package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class MaintainConnection {

	public static void connectLocalhostWithUserAndPassword(String dbName) {
		if (ConnectionStatus.getInstance().getConnection() == null) {
			LocalhostConnector.openConnectionWithUserAndPassword(dbName);
		}
		try {
			String conUser = ConnectionStatus.getInstance().getConnection()
					.getMetaData().getUserName().toString();
			String expectedUser = ConnectorData.USER + "@localhost";
			if (!conUser.equals(expectedUser)) {
				System.out.println("user is not '" + expectedUser + "' but '"
						+ conUser + "'.");
				LocalhostConnector.closeConnection();
				LocalhostConnector.openConnectionWithUserAndPassword(dbName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
