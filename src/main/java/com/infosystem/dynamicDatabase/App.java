package com.infosystem.dynamicDatabase;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.dbSchema.DbManager;
import com.infosystem.dynamicDatabase.metaTablesMethods.CreateMetatables;

public class App {

	public static void main(String[] args) throws SQLException {
		przygotujDbDoDzialania();
	}

	private static void przygotujDbDoDzialania() {
		MaintainConnection.connectLocalhost("");
		if (!DbManager.ifDbExists(DB)) {
			DbManager.createDb(DB);
			DbManager.useDb(DB);
			CreateMetatables.create();
		}
	}

}
