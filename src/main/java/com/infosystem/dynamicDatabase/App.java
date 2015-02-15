package com.infosystem.dynamicDatabase;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;
import static com.infosystem.dynamicDatabase.metaTablesMethods.CreateMetatables.setDatabaseWithMetatables;

import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws SQLException {
		setDatabaseWithMetatables(DB);
	}

}
