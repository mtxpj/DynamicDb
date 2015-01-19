package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManager {

	private ResultSet rs;

	public void addColumnToTable(String db, String tableName,
			ColumnDefinition columnDefinition) {
		MaintainConnection.connect(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		ColumnManagerSqlQuery.addColumnToTable(tableName,
				columnDefinition);
		String sql = query.getSb();
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ColumnDefinition getColumnFromTable(String db,
			String columnsTableName, String columnId) {
		MaintainConnection.connect(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		ColumnManagerSqlQuery.getColumnFromTable(columnsTableName,
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
