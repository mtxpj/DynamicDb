package com.infosystem.dynamicDatabase.dbMetadata;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.dbSchema.MetaTableManager;
import com.infosystem.dynamicDatabase.methods.TableExist;

public class MetaTableManagerTest {
	private static final String TEST_DB = Metadata.getTestDb();
	private static final String TABLES_TABLE_NAME = Metadata
			.getTablesTableName();
	private static final String SAMPLE_TABLE = Metadata.getSampleTable();

	@Test
	public void shouldAddTableProperlyTest() {
		// given
		MaintainConnection.connect("");
		// when
		MetaTableManager mtm = new MetaTableManager();
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
		MetaTableManager mtm = new MetaTableManager();
		mtm.removeTable(TEST_DB, TABLES_TABLE_NAME, SAMPLE_TABLE);
		// then
		try {
			Assert.assertEquals(false, TableExist.ifExist(SAMPLE_TABLE));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
