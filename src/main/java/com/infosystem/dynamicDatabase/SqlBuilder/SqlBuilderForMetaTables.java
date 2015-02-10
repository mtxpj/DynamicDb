package com.infosystem.dynamicDatabase.SqlBuilder;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.COLUMNS_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.ConnectorData.TABLES_TABLE_NAME;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.COLUMNS_ORDER;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.COLUMN_DEFINITION;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.DATA_TYPE;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.HTML_LABEL;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.ID;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.PLAIN_LABEL;
import static com.infosystem.dynamicDatabase.constant.MetaTablesData.TABLES_ID;

import java.util.List;

import com.infosystem.dynamicDatabase.constant.MetaTablesData;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderForMetaTables {

	public static String addNewTableToTablesTable(
			TableDefinition tableDefinition) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(TABLES_TABLE_NAME);
		sb.append(" ( id, ");
		sb.append(MetaTablesData.ID);
		sb.append(" )\nVALUES\n( NULL, '");
		sb.append(tableDefinition.getId());
		sb.append("' );");
		return sb.toString();
	}

	public static String addNewColumnsToColumnsTable(
			TableDefinition tableDefinition, int tableKey) {
		List<ColumnDefinition> colList = tableDefinition.getColumnList();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(COLUMNS_TABLE_NAME);
		sb.append(metaColumnsFieldsToInsert());
		sb.append("\nVALUES\n");
		for (ColumnDefinition columnDefinition : colList) {
			sb.append(prepareValuesFromColumnDefinition(columnDefinition,
					tableKey));
		}
		sb = cutLastCharactersFromStringBuilder(sb, 2);
		sb.append(";");
		return sb.toString();
	}

	private static String prepareValuesFromColumnDefinition(
			ColumnDefinition cd, int tableKey) {
		StringBuilder sb = new StringBuilder();
		sb.append("( '");
		sb.append(cd.getId());
		sb.append("', ");
		sb.append(columnOrderToString(cd));
		sb.append(", ");
		sb.append(cd.getColumnDef());
		sb.append(", ");
		sb.append(cd.getHtmlLabel());
		sb.append(", ");
		sb.append(cd.getPlainLabel());
		sb.append(", '");
		sb.append(cd.getDataType().toString());
		sb.append("', ");
		sb.append(tableKey);
		sb.append(" ),\n");
		return sb.toString();
	}

	private static String columnOrderToString(ColumnDefinition cd) {
		String colOrd = "null";
		if (cd.getOrder() != 0) {
			colOrd = String.valueOf(cd.getOrder());
		}
		return colOrd;
	}

	private static String metaColumnsFieldsToInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ( ");
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
		sb.append(", ");
		sb.append(TABLES_ID);
		sb.append(" )");
		return sb.toString();
	}

	public static StringBuilder cutLastCharactersFromStringBuilder(
			StringBuilder sb, int charCount) {
		String str = sb.substring(0, sb.length() - charCount);
		sb = new StringBuilder();
		sb.append(str);
		return sb;
	}

}
