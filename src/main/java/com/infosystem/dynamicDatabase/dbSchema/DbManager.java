package com.infosystem.dynamicDatabase.dbSchema;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.DbManagerSqlQuery;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class DbManager {

	public static void createDb(String db) {
		MaintainConnection.connectToDatabase("");
		String createDb = DbManagerSqlQuery.createDb(db);
		try {
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(createDb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDb(String dbName) {
		MaintainConnection.connectToDatabase("");
		String sql = DbManagerSqlQuery.dropDb(dbName);
		try {
			ConnectionStatus.getInstance().getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean ifDbExists(String dbName) {
		boolean existence = false;
		MaintainConnection.connectToDatabase("");
		try {
			DatabaseMetaData dbm = ConnectionStatus.getInstance()
					.getConnection().getMetaData();
			ResultSet rs = dbm.getCatalogs();
			while (rs.next()) {
				if (rs.getString(1).matches(dbName)) {
					existence = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existence;
	}

	public static void useDb(String db) {
		MaintainConnection.connectToDatabase(db);
		String sql = DbManagerSqlQuery.useDb(db);
		try {
			ConnectionStatus.getInstance().getStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connected to: " + db);
	}
}
