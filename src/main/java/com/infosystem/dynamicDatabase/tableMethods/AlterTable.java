package com.infosystem.dynamicDatabase.tableMethods;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class AlterTable {
	public void addForeignKey(String table, String column, String refTable,
			String refColumn) {
		MaintainConnection
				.connectToDatabase(ConnectorData.DB);
		String sql = SqlBuilder.addForeignKey(table, column, refTable,
				refColumn);
		try {
			ConnectionStatus.getInstance().getStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
