package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManager {

	public void addColumnToTable(String db, String tableName,
			ColumnDefinition columnDefinition) throws SQLException {
		MaintainConnection.connectLocalhostWithUserAndPassword(db);
		new ColumnManagerSqlQuery().addColumnToTable(tableName,
				columnDefinition);
		String sql = new ColumnManagerSqlQuery().getSb();
		try {
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ColumnDefinition getColumnFromColumnsTable(String columnId) {
		ResultSet rs = null;
		try {
			MaintainConnection
					.connectLocalhostWithUserAndPassword(ConnectorData.DB);
			rs = ConnectionStatus
					.getInstance()
					.getStatement()
					.executeQuery(
							new ColumnManagerSqlQuery().getColumnFromTable(
									ConnectorData.COLUMNS_TABLE_NAME, columnId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultsetManager.getColumnDefinition(rs);
	}
}
