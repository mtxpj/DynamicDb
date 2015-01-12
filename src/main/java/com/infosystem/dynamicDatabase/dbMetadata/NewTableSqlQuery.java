package com.infosystem.dynamicDatabase.dbMetadata;

public class NewTableSqlQuery {

	public static String addTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO meta_tables ( table_name )\nVALUES \n( ");
		sb.append(tableId);
		sb.append(" );");
		return sb.toString();
	}

	public static String removeTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM meta_tables WHERE table_name=");
		sb.append(tableId);
		sb.append(";");
		return sb.toString();
	}

}
