package com.infosystem.dynamicDatabase.methods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DynDataManCheckExist {

	public static boolean tableExist(java.sql.Connection connection, String tableName) throws SQLException {
		java.sql.DatabaseMetaData dbm = connection.getMetaData();
		ResultSet rs = dbm.getTables(null, null, tableName, null);
		if (rs.next()) {
			return true;
		}
		return false;
	}
}
