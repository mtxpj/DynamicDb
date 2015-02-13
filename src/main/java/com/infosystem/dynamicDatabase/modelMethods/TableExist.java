package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;

public class TableExist {

	public static boolean ifExist(int tableKey) throws SQLException {
		java.sql.DatabaseMetaData dbm = ConnectionStatus.getInstance()
				.getConnection().getMetaData();
		ResultSet tables = dbm.getTables(null, null, String.valueOf(tableKey),
				null);
		if (tables.next()) {
			return true;
		}
		return false;
	}
}
