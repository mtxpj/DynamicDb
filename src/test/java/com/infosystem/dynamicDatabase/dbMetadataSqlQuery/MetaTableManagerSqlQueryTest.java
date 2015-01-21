package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.TableManagerSqlQuery;

public class MetaTableManagerSqlQueryTest {

	@Test
	public void testAddTable() {
		// given
		String expected = "INSERT INTO all_tables VALUES ( sample_table_name );";
		// when
		String actual = TableManagerSqlQuery.addTable(DataForTests.getTablesTableName(),
				DataForTests.getSampleTable());
		// then
		Assert.assertEquals(expected, actual);
		
	}

	@Test
	public void testRemoveTable() {
		// given
		String expected = "DELETE FROM all_tables WHERE table_name=sample_table_name ;";
		// when
		String actual = TableManagerSqlQuery.removeTable(DataForTests.getTablesTableName(),
				DataForTests.getSampleTable());
		// then
		Assert.assertEquals(expected, actual);
	}

}
