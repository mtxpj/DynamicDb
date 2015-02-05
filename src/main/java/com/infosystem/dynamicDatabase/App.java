package com.infosystem.dynamicDatabase;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.constant.MetaTablesData;
import com.infosystem.dynamicDatabase.dbSchema.DbManager;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;
import com.infosystem.dynamicDatabase.modelMethods.TableDefinitionManager;
import com.infosystem.dynamicDatabase.tableMethods.AlterTable;

public class App {

	public static void main(String[] args) throws SQLException {
		MaintainConnection.connectLocalhostWithUserAndPassword("");
		DbManager.createDb(ConnectorData.DB);
		DbManager.useDb(ConnectorData.DB);
		createTablesTable();
		createColumnsTable();
		new AlterTable().addForeignKey(ConnectorData.TABLES_TABLE_NAME,
				MetaTablesData.COLUMN_LIST, ConnectorData.COLUMNS_TABLE_NAME,
				"id");

	}

	private static void createTablesTable() {
		new DynamicDatabaseManagerMethods()
				.createOrUpdate(new TableDefinitionManager()
						.createTableDefinition(ConnectorData.TABLES_TABLE_NAME,
								new MetaTablesData()
										.createMetaTablesColDefList()));
	}

	private static void createColumnsTable() {
		new DynamicDatabaseManagerMethods()
				.createOrUpdate(new TableDefinitionManager()
						.createTableDefinition(
								ConnectorData.COLUMNS_TABLE_NAME,
								new MetaTablesData()
										.createMetaColumnsColDefList()));
	}
}
