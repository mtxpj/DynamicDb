package com.infosystem.dynamicDatabase.SqlBuilder;

public class DbManagerSqlQuery {

	public static String createDb(String dbName) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE DATABASE IF NOT EXISTS ");
		sb.append(dbName);
		sb.append(";");
		return sb.toString();
	}

	public static String dropDb(String dbName) {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP DATABASE ");
		sb.append(dbName);
		sb.append(";");
		return sb.toString();
	}

	public static String useDb(String db) {
		StringBuilder sb = new StringBuilder();
		sb.append("USE ");
		sb.append(db);
		sb.append(";");
		return sb.toString();
	}

}
