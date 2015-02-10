package com.infosystem.dynamicDatabase.metaTablesMethods;

import static com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider.createSampleTableDefinition;
import static com.infosystem.dynamicDatabase.metaTablesMethods.MetaTablesHandler.createOrUpdate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class MetaTablesHandlerTest {
	private static final String TABLE_NAME = SampleTableDefinitionProvider.TABLICA_PROBNA;
	private static final int TABLES_NUMBER = 10;

	@BeforeClass
	public static void testCreate() {
		// given

		// when
		TableDefinition tdCreate = createSampleTableDefinition(TABLES_NUMBER);
		MetaTablesHandler.createOrUpdate(tdCreate);
		boolean bool = new DynamicDatabaseManagerMethods().existsTable(tdCreate
				.getId());
		// assert
		Assert.assertTrue(bool);
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
				.getId());
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

	@AfterClass
	public static void testAfterClassCleanUP() {
		if (new DynamicDatabaseManagerMethods().existsTable(TABLE_NAME)) {
			boolean bool = new DynamicDatabaseManagerMethods()
					.deleteTable(TABLE_NAME);
			assertTrue(bool);
		}
	}
}
