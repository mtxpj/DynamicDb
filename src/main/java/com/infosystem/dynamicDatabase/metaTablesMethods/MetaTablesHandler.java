package com.infosystem.dynamicDatabase.metaTablesMethods;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilderForMetaTables;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.mysql.jdbc.Statement;

public class MetaTablesHandler {

	public static int createOrUpdate(TableDefinition tableDefinition) {
		int tableKey = addNewTableToTablesTable(tableDefinition);
		addNewColumnsToColumnsTable(tableDefinition, tableKey);
		return tableKey;
	}

	private static int addNewTableToTablesTable(TableDefinition tableDefinition) {
		int key = -1;
		ResultSet rs;
		String command = SqlBuilderForMetaTables
				.addNewTableToTablesTable(tableDefinition);
		System.out.println(command);
		try {
			MaintainConnection.connectToDatabase(DB);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command, Statement.RETURN_GENERATED_KEYS);
			rs = ConnectionStatus.getInstance().getStatement()
					.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			System.out.println(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	private static void addNewColumnsToColumnsTable(
			TableDefinition tableDefinition, int tableKey) {
		String command = SqlBuilderForMetaTables.addNewColumnsToColumnsTable(
				tableDefinition, tableKey);
		System.out.println(command);
		try {
			MaintainConnection.connectToDatabase(DB);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
