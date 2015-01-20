package com.infosystem.dynamicDatabase.dbStructure;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.dbSchema.ColumnManager;
import com.infosystem.dynamicDatabase.model.TableDefinitionTest;

public class ColumnManagerTest {

	@Test
	public void shouldAddColumnProperly() throws SQLException {
		// given
		ColumnManager expected = new ColumnManager();
		expected.addColumnToTable(DataForTests.getTestDb(),
				DataForTests.getColumnsTableName(),
				TableDefinitionTest.createColumnDefinitionWithStupidData(1));
		// when
		ColumnManager actual = new ColumnManager();
		actual.getColumnFromTable(DataForTests.getColumnsTableName(),
				DataForTests.getColumnsTableName(), DataForTests.getColumnId());
		// then
		Assert.assertEquals(expected, actual);
	}
}
