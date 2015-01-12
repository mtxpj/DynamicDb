package com.infosystem.dynamicDatabase.dbMetadata;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class AddNewColumn {
	private final String COLUMNS_TABLE_NAME = "meta_columns";

	public void addColumnToTable(String db, String tableName, ColumnDefinition columnDefinition) {
	MaintainConnection.connect(db);
	String sql = NewColumnSqlQuery.addColumn(tableName, columnDefinition);
	
	}
}
