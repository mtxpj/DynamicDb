package com.infosystem.dynamicDatabase.methods;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class DynamicDatabaseManagerCommandsTest {
	private static final String TABLICA_PROBNA = "tablica_probna";
	private static TableDefinition tableDefinition;

	@BeforeClass
	public static void oneTimeSetUp() {
		tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLICA_PROBNA);
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < 10; i += 1) {
			ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setDataType(DataType.DATE);
			exampleColumnList.add(i, exampleColumnDefinition);
		}
		tableDefinition.setColumnList(exampleColumnList);
		LocalhostConnector.openConnectionWithUserAndPassword("test");
	}

	@Test
	public final void testCreateOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteTable() {
		fail("Not yet implemented");
	}

	@Test
	public final void testExistsTable() {
		fail("Not yet implemented");
	}

	@Test
	public final void testInsertDataRow() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetDataRows() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteDataRow() {
		fail("Not yet implemented");
	}

	@Test
	public final void testUpdateDataRow() {
		fail("Not yet implemented");
	}

}
