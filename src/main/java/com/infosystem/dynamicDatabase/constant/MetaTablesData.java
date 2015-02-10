package com.infosystem.dynamicDatabase.constant;

import java.util.ArrayList;
import java.util.List;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.Null;

public class MetaTablesData {
	public static final String ID = "name";
	public static final String COLUMNS_ORDER = "column_order";
	public static final String COLUMN_DEFINITION = "column_definition";
	public static final String HTML_LABEL = "html_label";
	public static final String PLAIN_LABEL = "plain_label";
	public static final String DATA_TYPE = "data_type";
	public static final String COLUMN_LIST = "column_list";
	public static final String TABLES_ID = "tables_id";

	public List<ColumnDefinition> columnsCdl = new ArrayList<ColumnDefinition>();
	public List<ColumnDefinition> tablesCdl = new ArrayList<ColumnDefinition>();

	public List<ColumnDefinition> createMetaTablesColDefList() {
		tablesCdl.add(new ColumnDefinition(ID, 1, Null.NOT_NULL, "htmlLabel",
				"plainLabel", DataType.STRING));
		return tablesCdl;
	}

	public List<ColumnDefinition> createMetaColumnsColDefList() {
		columnsCdl.add(new ColumnDefinition(ID, 1, Null.NOT_NULL, "htmlLabel",
				"plainLabel", DataType.STRING));
		columnsCdl.add(new ColumnDefinition(COLUMNS_ORDER, 2, Null.NULL,
				"htmlLabel", "plainLabel", DataType.NUMBER));
		columnsCdl.add(new ColumnDefinition(COLUMN_DEFINITION, 3, Null.NULL,
				"htmlLabel", "plainLabel", DataType.PREDEFINED_VALUE));
		columnsCdl.add(new ColumnDefinition(HTML_LABEL, 4, Null.NULL,
				"htmlLabel", "plainLabel", DataType.STRING));
		columnsCdl.add(new ColumnDefinition(PLAIN_LABEL, 5, Null.NULL,
				"htmlLabel", "plainLabel", DataType.STRING));
		columnsCdl.add(new ColumnDefinition(DATA_TYPE, 6, Null.NOT_NULL,
				"htmlLabel", "plainLabel", DataType.STRING));
		columnsCdl.add(new ColumnDefinition(TABLES_ID, 7, Null.NULL,
				"htmlLabel", "plainLabel", DataType.NUMBER));
		return columnsCdl;
	}
}
