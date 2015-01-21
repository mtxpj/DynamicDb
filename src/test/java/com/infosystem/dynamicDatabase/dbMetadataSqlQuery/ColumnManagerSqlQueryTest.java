package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.model.TableDefinitionTest;

public class ColumnManagerSqlQueryTest {

	@Test
	public void shouldProperlyReturnAddColumnQuery() {
		// given
		String expected = "INSERT INTO all_columns "
				+ "( id, column_order, column_definition, html_label, plain_label, datatype )"
				+ "\nVALUES\n( column_1, 1, NULL, html_label.1, plainLabel1, DATE );";
		// when
		String actual = ColumnManagerSqlQuery.addColumnToTable(
				DataForTests.getColumnsTableName(),
				TableDefinitionTest.createColumnDefinitionWithStupidData(1));
		// then
		Assert.assertEquals(expected, actual);
	}

}
