package com.infosystem.dynamicDatabase.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LocalhostConnector {

	private static final String dbClass = "com.mysql.jdbc.Driver";
	public static final String hostUrl = "jdbc:mysql://localhost/";
	private static String databaseUrl;
	public final static String USER = "eclipse";
	private final static String PASS = "userdwa";

	public static void openConnection(String dbName) {

		databaseUrl = hostUrl + dbName;

		try {

			Class.forName(dbClass);
			System.out.println("Connecting to database...");
			Connection connection = DriverManager.getConnection(databaseUrl);
			Statement statement = connection.createStatement();
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

	public static void openConnectionWithUserAndPassword(String dbName) {
		databaseUrl = hostUrl + dbName;
		Properties props = new Properties();
		props.put("user", USER);
		props.put("password", PASS);
		Connection connection;
		Statement statement;
		try {
			Class.forName(dbClass);
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
