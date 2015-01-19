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

	private static Connection connection;
	private static Statement statement;

	public static void openConnection(String dbName) {

		databaseUrl = hostUrl + dbName;

		try {

			Class.forName(dbClass);
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(databaseUrl);
			statement = connection.createStatement();

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

		if (connection != null) {
			System.out.println("Connected to: " + dbName);
		}

		ConnectionStatus.connection = connection;
		ConnectionStatus.statement = statement;
	}

	public static void openConnectionWithUserAndPassword(String DB_NAME) {
		databaseUrl = hostUrl + DB_NAME;
		Properties props = new Properties();
		props.put("user", USER);
		props.put("password", PASS);
		try {
			Class.forName(dbClass);
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(databaseUrl, props);
			statement = connection.createStatement();

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

		if (connection != null) {
			System.out.println("Connected to: " + DB_NAME);
		}

		ConnectionStatus.connection = connection;
		ConnectionStatus.statement = statement;
	}

	public static void closeConnection() {

		if (ConnectionStatus.connection != null) {

			try {
				ConnectionStatus.connection.close();

			} catch (SQLException sqle) {
				System.out.println("Failed to close connection");
				sqle.printStackTrace();
			}
		}

		if (ConnectionStatus.statement != null) {

			try {
				ConnectionStatus.statement.close();

			} catch (SQLException sqle) {
				System.out.println("Failed to close connection");
				sqle.printStackTrace();
			}
		}

		System.out.println("Connection closed. Goodbye!");
	}

}
