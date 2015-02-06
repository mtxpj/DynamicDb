package com.infosystem.dynamicDatabase.metaTablesMethods;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilderForMetaTables;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class MetaTablesHandler {

	public static void createOrUpdate(TableDefinition tableDefinition) {
		addNewTableToTablesTable(tableDefinition);
		addNewColumnsToColumnsTable(tableDefinition);
	}

	private static void addNewColumnsToColumnsTable(
			TableDefinition tableDefinition) {
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB);
			String command = SqlBuilderForMetaTables
					.addNewColumnsToColumnsTable(tableDefinition);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addNewTableToTablesTable(TableDefinition tableDefinition) {
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB);
			String command = SqlBuilderForMetaTables
					.addNewTableToTablesTable(tableDefinition);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
