package com.infosystem.dynamicDatabase.dbMetadata;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;

public class Metadata {

	final static String LOCALHOST = "";
	private static final String TEST_DB = "tdd_db";
	private static final String COLUMNS_TABLE_NAME = "meta_columns";
	private static final String TABLES_TABLE_NAME = "meta_tables";
	private static final String SAMPLE_TABLE = "new_table_name";
	private static final String COLUMN_ID = "name_id";

	public static ColumnDefinition createColumnDefinition() {
		ColumnDefinition columnDefinition = new ColumnDefinition();
		columnDefinition.setId(COLUMN_ID);
		columnDefinition.setOrder(1);
		columnDefinition.setColumnDef("definition_column");
		columnDefinition.setHtmlLabel("www.form.com/12345");
		columnDefinition.setPlainLabel("label_plain");
		DataType dataType = DataType.STRING;
		columnDefinition.setDataType(dataType);
		return columnDefinition;
	}

	public static String getLocalhost() {
		return LOCALHOST;
	}

	public static String getSampleTable() {
		return SAMPLE_TABLE;
	}

	public static String getTestDb() {
		return TEST_DB;
	}

	public static String getColumnsTableName() {
		return COLUMNS_TABLE_NAME;
	}

	public static String getTablesTableName() {
		return TABLES_TABLE_NAME;
	}

	public static String getColumnId() {
		return COLUMN_ID;
	}
}
