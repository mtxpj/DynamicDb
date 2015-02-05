package com.infosystem.dynamicDatabase.tablesTableSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.model.TableDefinitionTest;

public class ColumnManagerSqlQueryTest {

	@Test
	public void shouldProperlyReturnAddColumnQuery() {
		// given
		String expected = "INSERT INTO all_columns "
				+ "( id, column_order, column_definition, html_label, plain_label, datatype )"
				+ "\nVALUES\n( column_1, 1, NULL, html_label.1, plainLabel1, DATE );";
		// when
		ColumnManagerSqlQuery cmsq = new ColumnManagerSqlQuery();
		cmsq.addColumnToTable(ConnectorData.COLUMNS_TABLE_NAME,
				TableDefinitionTest.createColumnDefinitionWithStupidData(1));
		String actual = cmsq.getSb();
		// then
		Assert.assertEquals(expected, actual);
	}
}
