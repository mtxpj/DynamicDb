package com.infosystem.dynamicDatabase.dbMetadata;

public class DbManagerSqlQuery {

	public static String createDb(String dbName) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE DATABASE ");
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

}
