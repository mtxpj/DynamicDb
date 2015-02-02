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
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDb(String dbName) {
		MaintainConnection.connect(LocalhostConnector.hostUrl);
		String sql = DbManagerSqlQuery.dropDb(dbName);
		try {
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ifDbExists(String dbName) {
		boolean existence = false;
		MaintainConnection.connect(LocalhostConnector.hostUrl);
		java.sql.DatabaseMetaData dbm;
		try {
			dbm = ConnectionStatus.getInstance().getConnection().getMetaData();
			ResultSet rs = dbm.getCatalogs();
			while (rs.next()) {
				if (rs.getString(1) == dbName) {
					existence = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existence;
	}
}
