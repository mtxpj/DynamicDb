package com.infosystem.dynamicDatabase.connection;

import java.sql.Connection;
import java.sql.Statement;

public class ConnectionStatus {

	private Connection connection;
	private Statement statement;

	private static ConnectionStatus instance = new ConnectionStatus();

	private ConnectionStatus() {
	}

	// Get the only object available
	public static ConnectionStatus getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

}