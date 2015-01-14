package com.infosystem.dynamicDatabase.dbMetadata;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;

public class ColumnManagerSqlQuery {
	static StringBuilder sb = new StringBuilder();

	public static String addColumnToMetaTable(String metaTableName,
			ColumnDefinition columnDefinition) {
		sb.append("INSERT INTO ");
		sb.append(metaTableName);
		sb.append(" ( column_name, order, column_definition, html_label, plain_label, datatype )\nVALUES\n( ");
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

	public static String getColumnFromMetaTable(
			String metaColumnsTableName, String columnId) {

		return null;
	}

}
