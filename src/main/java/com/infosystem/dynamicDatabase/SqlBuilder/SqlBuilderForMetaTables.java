package com.infosystem.dynamicDatabase.SqlBuilder;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.COLUMNS_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.ConnectorData.TABLES_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.COLUMNS_ORDER;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.COLUMN_DEFINITION;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.DATA_TYPE;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.HTML_LABEL;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.ID;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.PLAIN_LABEL;

import java.util.List;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderForMetaTables {

	public static String addNewTableToTablesTable(
			TableDefinition tableDefinition) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(TABLES_TABLE_NAME);
		sb.append(" FIELDS ( ");
		// loop
		sb.append(" )\nVALUES\n( ");
		// loop
		sb.append(" );");
		return sb.toString();
	}

	public static String addNewColumnsToColumnsTable(
			TableDefinition tableDefinition) {
		List<ColumnDefinition> colList = tableDefinition.getColumnList();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(COLUMNS_TABLE_NAME);
		sb.append(metaColumnsFieldsToInsert());
		sb.append("\nVALUES\n");
		for (ColumnDefinition columnDefinition : colList) {
			sb.append(getRowFromColumnDefinition(columnDefinition));
		}
		sb.replace(sb.length()-2, sb.length(), ";");
		return sb.toString();
	}

	private static String getRowFromColumnDefinition(ColumnDefinition cd) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(cd.getId());
		sb.append(", ");
		sb.append(String.valueOf(cd.getOrder()));
		sb.append(", ");
		sb.append(cd.getColumnDef());
		sb.append(", ");
		sb.append(cd.getHtmlLabel());
		sb.append(", ");
		sb.append(cd.getPlainLabel());
		sb.append(", ");
		sb.append(cd.getDataType().toString());
		sb.append(" ),\n");
		return sb.toString();
	}

	private static String metaColumnsFieldsToInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append(" FIELDS ( ");
		sb.append(ID);
		sb.append(", ");
		sb.append(COLUMNS_ORDER);
		sb.append(", ");
		sb.append(COLUMN_DEFINITION);
		sb.append(", ");
		sb.append(HTML_LABEL);
		sb.append(", ");
		sb.append(PLAIN_LABEL);
		sb.append(", ");
		sb.append(DATA_TYPE);
		sb.append(" )");
		return sb.toString();
	}
}
