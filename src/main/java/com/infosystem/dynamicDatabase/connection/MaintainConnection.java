package com.infosystem.dynamicDatabase.connection;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class MaintainConnection {

	public static void connectLocalhost(String dbName) {
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
		} catch (com.mysql.jdbc.exceptions.MySQLNonTransientException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
