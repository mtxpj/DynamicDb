package com.infosystem.dynamicDatabase.metaTablesMethods;

import static com.infosystem.dynamicDatabase.DataForTests.DataForTests.TABLES_NUMBER;
import static com.infosystem.dynamicDatabase.DataForTests.DataForTests.TABLICA_PROBNA;
import static com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider.createSampleTableDefinition;
import static com.infosystem.dynamicDatabase.metaTablesMethods.MetaTablesHandler.createOrUpdate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class MetaTablesHandlerTest {
	private static final String TABLE_NAME = TABLICA_PROBNA;
	private static int tableKey = -1;

	@Test
	public void testCreate() {
		// given
		TableDefinition tdCreate = createSampleTableDefinition(TABLES_NUMBER);
		// when
		MetaTablesHandler.createOrUpdate(tdCreate);
		tableKey = tdCreate.getKey();
		// assert
		Assert.assertTrue(new DynamicDatabaseManagerMethods()
				.existsTable(tdCreate.getKey()));
	}

	@Test
	public void testCreateOrUpdate() {
		// when
		TableDefinition tdCreate = createSampleTableDefinition(TABLES_NUMBER);
		TableDefinition tdUpdate = createSampleTableDefinition(TABLES_NUMBER);
		QueryParams qp = new QueryParams(TABLE_NAME, 1, TABLES_NUMBER);
		List<DataRow> expected = new ArrayList<DataRow>();
		List<DataRow> updatedExpected = new ArrayList<DataRow>();

		// than
		// create
		createOrUpdate(tdCreate);
		boolean bool = new DynamicDatabaseManagerMethods().existsTable(tdCreate
				.getKey());
		// assert
		assertTrue(bool);
		// read
		List<DataRow> actualDataRowList = new DynamicDatabaseManagerMethods()
				.getDataRows(qp);
		// assert
		assertEquals(expected, actualDataRowList);
		// update
		createOrUpdate(tdUpdate);
		actualDataRowList = new DynamicDatabaseManagerMethods().getDataRows(qp);
		// assert
		assertEquals(updatedExpected, actualDataRowList);
		// del
		bool = new DynamicDatabaseManagerMethods()
				.deleteTable(tdCreate.getId());
		// assert
		assertTrue(bool);
	}

	@Test
	public void testAfterClassCleanUP() {
		if (new DynamicDatabaseManagerMethods().existsTable(tableKey)) {
			assertTrue(new DynamicDatabaseManagerMethods()
					.deleteTable(TABLE_NAME));
		}
	}
}
