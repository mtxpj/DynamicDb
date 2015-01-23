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
			ColumnDefinition columnDefinition) throws SQLException {
		MaintainConnection.connectLocalhostWithUserAndPassword(db);
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		query.addColumnToTable(tableName, columnDefinition);
		String sql = query.getSb();
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ColumnDefinition getColumnFromTable(String db,
			String columnsTableName, String columnId) {
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(db);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ColumnManagerSqlQuery query = new ColumnManagerSqlQuery();
		query.getColumnFromTable(columnsTableName, columnId);
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
