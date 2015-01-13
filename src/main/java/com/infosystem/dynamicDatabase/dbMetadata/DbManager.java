package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class DbManager {

	public void createDb(String dbName) {
		MaintainConnection.connect("");
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
}
