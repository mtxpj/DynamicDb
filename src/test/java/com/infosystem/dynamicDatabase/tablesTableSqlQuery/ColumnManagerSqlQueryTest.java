package com.infosystem.dynamicDatabase.tablesTableSqlQuery;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.ColumnManagerSqlQuery;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.model.TableDefinitionTest;

public class ColumnManagerSqlQueryTest {
	 Logger logger = LoggerFactory.getLogger(ColumnManagerSqlQuery.class);
		
	@Test
	public void shouldProperlyReturnAddColumnQuery() {
		// given
		String expected = "INSERT INTO all_columns "
				+ "( name, column_order, column_definition, html_label, plain_label, data_type, tables_id )"
				+ "\nVALUES\n( 'column_1', 1, false, 'html_label.1', 'plain_Label.1', 'DATE', 1 );";
		// when
		ColumnManagerSqlQuery cmsq = new ColumnManagerSqlQuery();
		cmsq.addColumnToTable(ConnectorData.COLUMNS_TABLE_NAME,
				TableDefinitionTest.createSampleColumnDefinition(1,
						DataForTests.TABLE_ONE_PRIM_KEY));
		String actual = cmsq.getSb();
		// then
		Assert.assertEquals(expected, actual);
	}
}
