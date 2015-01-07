package com.infosystem.dynamicDatabase.methods;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;

public class GetColumnNames {

	public static ArrayList<String> fromMetaData(String tableName) {
		ArrayList<String> columnNames = new ArrayList<String>();
		MaintainConnection.connect(tableName);
		try {
			Statement stmt = ConnectionStatus.connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsMd = rs.getMetaData();
			for (int i = 1; i <= rsMd.getColumnCount(); i++) {
				columnNames.add(rsMd.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnNames;
	}

	public static ArrayList<String> fromDataRow(DataRow row) {
		ArrayList<String> columnNames = new ArrayList<String>();
		Map<String, DataHolder> dataRow = row.getData();
		Set<String> columns = dataRow.keySet();
		columnNames.addAll(columns);
		return columnNames;
	}

}
