package com.infosystem.dynamicDatabase.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class LocalhostConnector {
	
	private static final String dbClass = "com.mysql.jdbc.Driver";
	public static final String hostUrl = "jdbc:mysql://localhost/";
	private static String databaseUrl;
	
	private static Connection connection;
	private static Statement statement;
	
	
	public static void openConnection (String DB_NAME) {
		
		databaseUrl = hostUrl + DB_NAME;
		
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
		
		if(connection!=null){
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
