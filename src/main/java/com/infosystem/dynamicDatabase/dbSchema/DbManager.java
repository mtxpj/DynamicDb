package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class DbManager {

	private static final String DB_TO_CONNECT = "test";

	public static void createDb(String dbName) {
		MaintainConnection.connect(DB_TO_CONNECT);
		String sql = DbManagerSqlQuery.createDb(dbName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDb(String dbName) {
		MaintainConnection.connect(LocalhostConnector.hostUrl);
		String sql = DbManagerSqlQuery.dropDb(dbName);
		try {
			ConnectionStatus.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ifDbExists(String dbName) {
		MaintainConnection.connect(LocalhostConnector.hostUrl);
		java.sql.DatabaseMetaData dbm;
		try {
			dbm = ConnectionStatus.connection.getMetaData();
			ResultSet rs = dbm.getCatalogs();
			while (rs.next()) {
				if (rs.getString(1) == dbName) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
