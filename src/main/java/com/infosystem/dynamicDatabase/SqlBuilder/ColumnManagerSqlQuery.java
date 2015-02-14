package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManagerSqlQuery {
	StringBuilder sb = new StringBuilder();

	public String addColumnToTable(String tableName,
			ColumnDefinition columnDefinition) {
		sb.append("INSERT INTO ");
		sb.append(tableName);
		sb.append(" ( name, column_order, column_definition, html_label, plain_label, data_type, tables_id )\nVALUES\n( '");
		sb.append(columnDefinition.getId());
		sb.append("', ");
		sb.append(String.valueOf(columnDefinition.getOrder()));
		sb.append(", ");
		sb.append(columnDefinition.isRequired());
		sb.append(", '");
		sb.append(columnDefinition.getHtmlLabel());
		sb.append("', '");
		sb.append(columnDefinition.getPlainLabel());
		sb.append("', '");
		sb.append(columnDefinition.getDataType().toString());
		sb.append("', ");
		sb.append(String.valueOf(columnDefinition.getTable_id()));
		sb.append(" );");
		return sb.toString();
	}

	public String getSb() {
		return sb.toString();
	}

	public String getColumnFromTable(String columnsTableName, String columnId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *");
		sb.append(" FROM ");
		sb.append(columnsTableName);
		sb.append(" WHERE name='");
		sb.append(columnId);
		sb.append("';");
		return sb.toString();
	}

}
