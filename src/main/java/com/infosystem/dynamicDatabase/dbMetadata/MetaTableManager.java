package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class MetaTableManager {
	public void addTable(String db, String metaTableName, String newTableName) {
		MaintainConnection.connect(db);
		String sql = MetaTableManagerSqlQuery.addTable(metaTableName, newTableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeTable(String db, String metaTableName, String newTableName) {
		MaintainConnection.connect(db);
		String sql = MetaTableManagerSqlQuery.removeTable(metaTableName,
				newTableName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
