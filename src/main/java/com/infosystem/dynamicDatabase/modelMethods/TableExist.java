package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;

public class TableExist {

	public static boolean ifExist(String tableName) throws SQLException {
		
		java.sql.DatabaseMetaData dbm = ConnectionStatus.getInstance().getConnection().getMetaData();
		ResultSet tables = dbm.getTables(null, null, tableName, null);
		
		if (tables.next()) {
			return true;
		}
		return false;
	}
}
