package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class AddNewTable {
	public void addTable(String newTableName, String db) {
		MaintainConnection.connect(db);
		String sql = NewTableSqlQuery.addTable(newTableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeTable(String tableName, String db) {
		MaintainConnection.connect(db);
		String sql = NewTableSqlQuery.removeTable(tableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
