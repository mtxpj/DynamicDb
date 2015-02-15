package com.infosystem.dynamicDatabase.tablesTableSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.TableManagerSqlQuery;
import com.infosystem.dynamicDatabase.constant.ConnectorData;

public class TablesTableManagerSqlQueryTest {

	@Test
	public void testAddTable() {
		// given
		String expected = "INSERT INTO all_tables (table_id)  VALUES ( sample_table_name );";
		// when
		String actual = TableManagerSqlQuery.addTable(
				ConnectorData.TABLES_TABLE_NAME, DataForTests.SAMPLE_TABLE);
		// then
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testRemoveTable() {
		// given
		String expected = "DELETE FROM all_tables WHERE table_name=sample_table_name ;";
		// when
		String actual = TableManagerSqlQuery.removeTable(
				ConnectorData.TABLES_TABLE_NAME, DataForTests.SAMPLE_TABLE);
		// then
		Assert.assertEquals(expected, actual);
	}

}
