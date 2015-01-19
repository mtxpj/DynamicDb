package com.infosystem.dynamicDatabase.dbStructure;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.dbSchema.ColumnManager;

public class ColumnManagerTest {

	@Test
	public void shouldAddColumnProperly() {
		// given
		ColumnManager expected = new ColumnManager();
		expected.addColumnToTable(DataForTests.getTestDb(),
				DataForTests.getColumnsTableName(),
				DataForTests.createSampleColumnDefinition());
		// when
		ColumnManager actual = new ColumnManager();
		actual.getColumnFromTable(DataForTests.getColumnsTableName(),
				DataForTests.getColumnsTableName(), DataForTests.getColumnId());
		// then
		Assert.assertEquals(expected, actual);
	}
}
