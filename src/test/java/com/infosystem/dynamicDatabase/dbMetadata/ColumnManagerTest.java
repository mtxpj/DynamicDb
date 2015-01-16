package com.infosystem.dynamicDatabase.dbMetadata;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.dbSchema.ColumnManager;

public class ColumnManagerTest {

	@Test
	public void shouldAddColumnProperly() {
		// given
		ColumnManager expected = new ColumnManager();
		expected.addColumnToMetaTable(Metadata.getTestDb(),
				Metadata.getColumnsTableName(),
				Metadata.createColumnDefinition());
		// when
		ColumnManager actual = new ColumnManager();
		actual.getColumnFromMetaTable(Metadata.getColumnsTableName(),
				Metadata.getColumnsTableName(), Metadata.getColumnId());
		// then
		Assert.assertEquals(expected, actual);
	}
}
