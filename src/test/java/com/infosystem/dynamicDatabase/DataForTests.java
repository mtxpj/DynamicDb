package com.infosystem.dynamicDatabase;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class DataForTests {
	private static final String DB_NAME = "test_db";
	private static final String TABLE_NAME = "test_table";

	public void createDb(String dbName) {
		String sql = newDbSqlQuery(dbName);
		MaintainConnection.connect("");
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String newDbSqlQuery(String dbName) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE ");
		sb.append(dbName);
		sb.append(" ;");
		return sb.toString();
	}

	public void createTable(String db, String tableName) {
		String sql = newTableSqlQuery(tableName);
		MaintainConnection.connect(db);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String newTableSqlQuery(String tableName) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE ");
		sb.append(tableName);
		sb.append(" ;");
		return sb.toString();
	}
}