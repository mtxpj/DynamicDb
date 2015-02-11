package com.infosystem.dynamicDatabase.dbStructure;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.dbSchema.ColumnManager;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinitionTest;

public class ColumnManagerTest {

	@Test
	public void shouldAddColumnProperly() throws SQLException {
		// FAILS WHEN tables_id = 1 DOESN'T EXIST
		// given
		ColumnDefinition expected = TableDefinitionTest
				.createSampleColumnDefinition(1,
						TableDefinitionTest.TABLE_ONE_PRIM_KEY);
		// when
		new ColumnManager().addColumnToTable(ConnectorData.DB,
				ConnectorData.COLUMNS_TABLE_NAME, expected);
		ColumnDefinition actual = new ColumnManager()
				.getColumnFromColumnsTable("column_1");
		// then
		Assert.assertEquals(actual.getTable_id(), expected.getTable_id());
		Assert.assertEquals(actual.getId(), expected.getId());
		Assert.assertEquals(actual.getOrder(), expected.getOrder());
		Assert.assertEquals(actual.getColumnDef(), expected.getColumnDef());
		Assert.assertEquals(actual.getHtmlLabel(), expected.getHtmlLabel());
		Assert.assertEquals(actual.getPlainLabel(), expected.getPlainLabel());
		Assert.assertEquals(actual.getDataType(), expected.getDataType());
	}
}
