package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManagerSqlQuery {
	StringBuilder sb = new StringBuilder();

	public String addColumnToTable(String tableName,
			ColumnDefinition columnDefinition) {
		sb.append("INSERT INTO ");
		sb.append(tableName);
		sb.append(" ( id, column_order, column_definition, html_label, plain_label, datatype )\nVALUES\n( ");
		sb.append(columnDefinition.getId());
		sb.append(", ");
		sb.append(String.valueOf(columnDefinition.getOrder()));
		sb.append(", ");
		sb.append(columnDefinition.getColumnDef());
		sb.append(", ");
		sb.append(columnDefinition.getHtmlLabel());
		sb.append(", ");
		sb.append(columnDefinition.getPlainLabel());
		sb.append(", ");
		sb.append(columnDefinition.getDataType().toString());
		sb.append(" );");
		return sb.toString();
	}

	public String getSb() {
		return sb.toString();
	}

	public String getColumnFromTable(String columnsTableName, String columnId) {
		// TODO
		return null;
	}

}
