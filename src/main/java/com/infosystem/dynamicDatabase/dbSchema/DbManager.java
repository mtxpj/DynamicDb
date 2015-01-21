package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class DbManager {

	public static void createDb(String dbName) throws SQLException {
		MaintainConnection.connectLocalhostWithUserAndPassword(dbName);
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
