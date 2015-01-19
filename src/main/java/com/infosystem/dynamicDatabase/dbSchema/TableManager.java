package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.TableManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class TableManager {
	public void addTable(String db, String metaTableName, String newTableName) {
		MaintainConnection.connect(db);
		String sql = TableManagerSqlQuery.addTable(metaTableName, newTableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeTable(String db, String metaTableName, String newTableName) {
		MaintainConnection.connect(db);
		String sql = TableManagerSqlQuery.removeTable(metaTableName,
				newTableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
