package com.infosystem.dynamicDatabase.dbStructure;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class TableManagerTest {
	private static final long ROW_ID = 14;
	private static final String TABLES_TABLE_NAME = DataForTests
			.getTablesTableName();
	private static final String SAMPLE_TABLE_NAME = DataForTests
			.getSampleTable();
	private static final String COLUMN_NAME = "table_id";

	@Test
	public void shouldAddNewTableToTablesTableProperlyTest()
			throws SQLException {
		// given
		DynamicDatabaseManagerMethods ddmm = new DynamicDatabaseManagerMethods();
		DataHolder value = new DataHolder();
		value.setDataType(DataType.STRING);
		value.setString(SAMPLE_TABLE_NAME);
		Map<String, DataHolder> data = new HashMap<String, DataHolder>();
		data.put(COLUMN_NAME, value);
		DataRow row = new DataRow();
		row.setRowId(ROW_ID);
		row.setTableId(TABLES_TABLE_NAME);
		row.setData(data);
		// when
		ddmm.insertDataRow(row);
		// then

		QueryParams queryParams = new QueryParams(TABLES_TABLE_NAME,
				(int) ROW_ID, 1);
		Assert.assertNull(ddmm.getDataRows(queryParams) != null);
	}

	@Test
	public void shouldRemoveTableProperlyTest() {
		// given
		DynamicDatabaseManagerMethods deleteTable = new DynamicDatabaseManagerMethods();
		// when
		// then
		Assert.assertTrue(deleteTable.deleteDataRow(TABLES_TABLE_NAME, ROW_ID));
	}
}
