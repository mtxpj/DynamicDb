package com.infosystem.dynamicDatabase.methods;

import static com.infosystem.dynamicDatabase.methods.SampleTableDefinitionProvider.TABLICA_PROBNA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderTest {

	@Test
	public final void testCreate() {
		String expected = "CREATE TABLE tablica_probna (\n" + "id INT NOT NULL AUTO_INCREMENT,\n" + "kolumna_1 VARCHAR (255) null, \n"
				+ "kolumna_2 VARCHAR (255) null, \n" + "kolumna_3 VARCHAR (255) null, \n" + "kolumna_4 VARCHAR (255) null, \n"
				+ "kolumna_5 VARCHAR (255) null, \n" + "kolumna_6 VARCHAR (255) null, \n" + "kolumna_7 VARCHAR (255) null, \n"
				+ "kolumna_8 VARCHAR (255) null, \n" + "kolumna_9 VARCHAR (255) null, \n" + "kolumna_10 VARCHAR (255) null, \n"
				+ "PRIMARY KEY ( id )\n" + ");";
		TableDefinition tabelDef = SampleTableDefinitionProvider.createSampleTableDefinition();
		String actual = SqlBuilder.createOrUpdate(tabelDef);
		assertEquals(expected, actual);
		tabelDef.getColumnList().remove(0);
		actual = SqlBuilder.createOrUpdate(tabelDef);
		assertEquals(expected, actual);
	}

	@Test
	public final void testDeleteTable() {
		String expected = "DROP TABLE tablica_probna ;";
		String actual = SqlBuilder.deleteTable(TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testExistsTable() {
		String expected = "SELECT 1 FROM tablica_probna LIMIT 1 ;";
		String actual = SqlBuilder.existsTable(TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testInsertDataRow() {
		String expected = "INSERT INTO tablica_probna (  )\nVALUES\n( l, k, j );";
		String actual = SqlBuilder.insertDataRow(SampleTableDefinitionProvider.getDataRow());
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Ignore
	@Test
	public final void testGetDataRows() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteDataRow() {
		String expected = "DELETE FROM tablica_probna WHERE id=1 ;";
		String actual = SqlBuilder.deleteDataRow(TABLICA_PROBNA, (long) 1);
		assertEquals(expected, actual);
	}

	@Ignore
	@Test
	public final void testUpdateDataRow() {
		fail("Not yet implemented");
	}

	@AfterClass
	public static void closingDown() {
		// LocalhostConnector.closeConnection();
	}

}
