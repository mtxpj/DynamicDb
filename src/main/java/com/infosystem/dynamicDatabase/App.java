package com.infosystem.dynamicDatabase;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.COLUMNS_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;
import static com.infosystem.dynamicDatabase.constant.ConnectorData.TABLES_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.COLUMN_LIST;

import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.MetaTablesData;
import com.infosystem.dynamicDatabase.dbSchema.DbManager;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.MetaDatabaseManagerMethods;
import com.infosystem.dynamicDatabase.modelMethods.TableDefinitionManager;
import com.infosystem.dynamicDatabase.tableMethods.AlterTable;

public class App {

	public static void main(String[] args) throws SQLException {
		przygotujDbDoDzialania();
	}

	private static void przygotujDbDoDzialania() {
		MaintainConnection.connectLocalhostWithUserAndPassword("");
		if (!DbManager.ifDbExists(DB)) {
			DbManager.createDb(DB);
			DbManager.useDb(DB);
			createMetaTables();
		}
	}

	private static void createMetaTables() {
		createTablesTable();
		createColumnsTable();
		new AlterTable().addForeignKey(TABLES_TABLE_NAME, COLUMN_LIST,
				COLUMNS_TABLE_NAME, "id");
	}

	private static void createTablesTable() {
		List<ColumnDefinition> createMetaTablesColDefList = new MetaTablesData()
				.createMetaTablesColDefList();
		TableDefinition createTableDefinition = new TableDefinitionManager()
				.createTableDefinition(TABLES_TABLE_NAME,
						createMetaTablesColDefList);
		new MetaDatabaseManagerMethods().createOrUpdate(createTableDefinition);
	}

	private static void createColumnsTable() {
		List<ColumnDefinition> createMetaColumnsColDefList = new MetaTablesData()
				.createMetaColumnsColDefList();
		TableDefinition createTableDefinition = new TableDefinitionManager()
				.createTableDefinition(COLUMNS_TABLE_NAME,
						createMetaColumnsColDefList);
		new MetaDatabaseManagerMethods().createOrUpdate(createTableDefinition);
	}
}
