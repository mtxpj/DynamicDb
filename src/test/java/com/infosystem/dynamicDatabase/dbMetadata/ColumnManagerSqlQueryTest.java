package com.infosystem.dynamicDatabase.dbMetadata;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;

public class ColumnManagerSqlQueryTest {

	private static final String COLUMNS_TABLE_NAME = "meta_columns";

	@Test
	public void shouldProperlyReturnAddColumnQuery() {
		// given
		ColumnDefinition columnDefinition = new ColumnDefinition();
		columnDefinition.setId("name_id");
		columnDefinition.setOrder(1);
		columnDefinition.setColumnDef("definition_column");
		columnDefinition.setHtmlLabel("www.form.com/12345");
		columnDefinition.setPlainLabel("label_plain");
		DataType dataType = DataType.STRING;
		columnDefinition.setDataType(dataType);
		String actual = "INSERT INTO meta_columns "
				+ "( column_name, order, column_definition, html_label, plain_label, datatype )"
				+ "\nVALUES\n( name_id, 1, definition_column, www.form.com/12345, label_plain, STRING );";
		// when
		String expected = ColumnManagerSqlQuery.addColumnToMetaTable(
				COLUMNS_TABLE_NAME, columnDefinition);
		// then
		Assert.assertEquals(expected, actual);
	}

}
