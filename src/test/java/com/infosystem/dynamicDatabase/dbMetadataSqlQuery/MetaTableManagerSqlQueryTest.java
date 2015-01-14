package com.infosystem.dynamicDatabase.dbMetadataSqlQuery;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.dbMetadata.MetaTableManagerSqlQuery;
import com.infosystem.dynamicDatabase.dbMetadata.Metadata;

public class MetaTableManagerSqlQueryTest {

	@Test
	public void testAddTable() {
		// given
		String expected = "INSERT INTO meta_tables VALUES ( new_table_name );";
		// when
		String actual = MetaTableManagerSqlQuery.addTable(Metadata.getTablesTableName(),
				Metadata.getSampleTable());
		// then
		Assert.assertEquals(expected, actual);
		
	}

	@Test
	public void testRemoveTable() {
		// given
		String expected = "DELETE FROM meta_tables WHERE table_name=new_table_name ;";
		// when
		String actual = MetaTableManagerSqlQuery.removeTable(Metadata.getTablesTableName(),
				Metadata.getSampleTable());
		// then
		Assert.assertEquals(expected, actual);
	}

}
