package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManager {

	private ResultSet rs;

	public void addColumnToMetaTable(String db, String metaColumnsTableName,
			ColumnDefinition columnDefinition) {
		MaintainConnection.connect(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		ColumnManagerSqlQuery.addColumnToMetaTable(metaColumnsTableName,
				columnDefinition);
		String sql = query.getSb();
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ColumnDefinition getColumnFromMetaTable(String db,
			String metaColumnsTableName, String columnId) {
		MaintainConnection.connect(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		ColumnManagerSqlQuery.getColumnFromMetaTable(metaColumnsTableName,
				columnId);
		String sql = query.getSb();
		try {
			rs = ConnectionStatus.statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ColumnDefinition cd = ResultsetManager.getColumnDefinition(rs);
		return cd;
	}
}
