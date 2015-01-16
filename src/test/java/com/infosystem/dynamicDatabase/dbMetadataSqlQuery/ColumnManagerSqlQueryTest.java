package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.dbMetadata.Metadata;

public class ColumnManagerSqlQueryTest {

	@Test
	public void shouldProperlyReturnAddColumnQuery() {
		// given
		String expected = "INSERT INTO meta_columns "
				+ "( column_name, order, column_definition, html_label, plain_label, datatype )"
				+ "\nVALUES\n( name_id, 1, definition_column, www.form.com/12345, label_plain, STRING );";
		// when
		String actual = ColumnManagerSqlQuery.addColumnToMetaTable(
				Metadata.getColumnsTableName(),
				Metadata.createColumnDefinition());
		// then
		Assert.assertEquals(expected, actual);
	}

}
