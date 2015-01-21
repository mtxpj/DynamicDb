package com.infosystem.dynamicDatabase.SqlBuilder;

public class TableManagerSqlQuery {

	public static String addTable(String tableName, String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(tableName);
		sb.append(" (table_id)  VALUES ( ");
		sb.append(tableId);
		sb.append(" );");
		return sb.toString();
	}

	public static String removeTable(String tableName, String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(tableName);
		sb.append(" WHERE table_name=");
		sb.append(tableId);
		sb.append(" ;");
		return sb.toString();
	}

}
