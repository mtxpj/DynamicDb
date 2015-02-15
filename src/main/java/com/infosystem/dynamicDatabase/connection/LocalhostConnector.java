package com.infosystem.dynamicDatabase.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class LocalhostConnector {

	public static void openConnectionWithUserAndPassword(String dbName) {
		String databaseUrl = ConnectorData.hostUrl.concat(dbName);
		Properties props = new Properties();
		props.put("user", ConnectorData.USER);
		props.put("password", ConnectorData.PASS);
		Connection connection;
		Statement statement;
		try {
			Class.forName(ConnectorData.dbClass);
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(databaseUrl, props);
			statement = connection.createStatement();
			ConnectionStatus.getInstance().setConnection(connection);
			ConnectionStatus.getInstance().setStatement(statement);
			if (connection != null) {
				System.out.println("Connected to: " + dbName);
			}
		} catch (ClassNotFoundException exc) {
			System.out.println("SQL driver not found");
			exc.printStackTrace();

		} catch (SQLException sqle) {
			System.out.println("Connection failed");
			sqle.printStackTrace();

		} catch (Exception exc) {
			System.out.println("Connection failed");
			exc.printStackTrace();
		}

	}

	public static void closeConnection() {

		if (ConnectionStatus.getInstance().getConnection() != null) {

			try {
				ConnectionStatus.getInstance().getConnection().close();

			} catch (SQLException sqle) {
				System.out.println("Failed to close connection");
				sqle.printStackTrace();
			}
		}

		if (ConnectionStatus.getInstance().getStatement() != null) {

			try {
				ConnectionStatus.getInstance().getStatement().close();

			} catch (SQLException sqle) {
				System.out.println("Failed to close connection");
				sqle.printStackTrace();
			}
		}

		System.out.println("Connection closed. Goodbye!");
	}

}
