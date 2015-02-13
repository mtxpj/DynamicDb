package com.infosystem.dynamicDatabase.dbSchema;

import static com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager.getColumnDefinition;
import static com.infosystem.dynamicDatabase.connection.MaintainConnection.connectLocalhost;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManager {

	public void addColumnToTable(String db, String tableName,
			ColumnDefinition columnDefinition) throws SQLException {
		connectLocalhost(db);
		String sql = new ColumnManagerSqlQuery().addColumnToTable(tableName,
				columnDefinition);
		try {
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ColumnDefinition getColumnFromColumnsTable(String columnId) {
		ResultSet rs = null;
		try {
			connectLocalhost(ConnectorData.DB);
			String columnFromTable = new ColumnManagerSqlQuery()
					.getColumnFromTable(ConnectorData.COLUMNS_TABLE_NAME,
							columnId);
			rs = ConnectionStatus.getInstance().getStatement()
					.executeQuery(columnFromTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getColumnDefinition(rs);
	}
}
