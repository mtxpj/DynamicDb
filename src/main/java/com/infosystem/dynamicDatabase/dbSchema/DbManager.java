package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class DbManager {

	public static void createDb(String db) {
		try {
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(DbManagerSqlQuery.createDb(db));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDb(String dbName) {
		MaintainConnection.connectLocalhostWithUserAndPassword(ConnectorData.hostUrl);
		String sql = DbManagerSqlQuery.dropDb(dbName);
		try {
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ifDbExists(String dbName) {
		boolean existence = false;
		MaintainConnection.connectLocalhostWithUserAndPassword(ConnectorData.hostUrl);
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

	public static void useDb(String db) {
		MaintainConnection.connectLocalhostWithUserAndPassword(db);
		String sql = DbManagerSqlQuery.useDb(db);
		try {
			ConnectionStatus.getInstance().getStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connected to: " + db);
	}
}
