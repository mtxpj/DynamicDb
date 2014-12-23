package com.infosystem.dynamicDatabase.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalhostConnector {
	private static Connection connection;
	public static Statement statement;
	private static String dbClass = "com.mysql.jdbc.Driver";
	private static String databaseUrl = "jdbc:mysql://localhost/";

	public static void connectToDb(String db) {
		databaseUrl = databaseUrl + db;
		try {
			Class.forName(dbClass);
			connection = DriverManager.getConnection(databaseUrl);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection() throws SQLException {
		connection.close();
		statement.close();
	}
}