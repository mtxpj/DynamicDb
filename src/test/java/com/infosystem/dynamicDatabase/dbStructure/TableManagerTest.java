package com.infosystem.dynamicDatabase.dbStructure;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.dbSchema.TableManager;
import com.infosystem.dynamicDatabase.methods.TableExist;

public class TableManagerTest {
	private static final String TEST_DB = DataForTests.getTestDb();
	private static final String TABLES_TABLE_NAME = DataForTests
			.getTablesTableName();
	private static final String SAMPLE_TABLE = DataForTests.getSampleTable();

	@Test
	public void shouldAddTableProperlyTest() {
		// given
		MaintainConnection.connect("");
		// when
		TableManager mtm = new TableManager();
		mtm.addTable(TEST_DB, TABLES_TABLE_NAME, SAMPLE_TABLE);
		// then
		try {
			Assert.assertEquals(true, TableExist.ifExist(SAMPLE_TABLE));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldRemoveTableProperlyTest() {
		// given
		MaintainConnection.connect("");
		// when
		TableManager mtm = new TableManager();
		mtm.removeTable(TEST_DB, TABLES_TABLE_NAME, SAMPLE_TABLE);
		// then
		try {
			Assert.assertEquals(false, TableExist.ifExist(SAMPLE_TABLE));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
