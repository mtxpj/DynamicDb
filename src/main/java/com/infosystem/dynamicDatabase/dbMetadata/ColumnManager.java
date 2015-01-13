package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManager {

	public void addColumnToTable(String db, String metaColumnsTableName,
			ColumnDefinition columnDefinition) {
		MaintainConnection.connect(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		query.addColumnToMetaTable(metaColumnsTableName, columnDefinition);
		String sql = query.getSb();
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
