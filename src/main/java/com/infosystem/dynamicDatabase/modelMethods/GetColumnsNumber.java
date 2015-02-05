package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;

public class GetColumnsNumber {

	public static int fromMetaData(String tableName) {
		int columnsNumber = -1;
		MaintainConnection.connectLocalhostWithUserAndPassword(tableName);
		try {
			Statement stmt = ConnectionStatus.getInstance().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsMd = rs.getMetaData();
			columnsNumber = rsMd.getColumnCount();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnsNumber;
	}

	public static int fromDataRow(DataRow row) {
		int columnsNumber = -1;
		Map<String, DataHolder> dataRow = row.getData();
		columnsNumber = dataRow.size();
		return columnsNumber;
	}

}
