package com.infosystem.dynamicDatabase.methods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider;
import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderTest {

	@Test
	public final void testCreate() {
		String expected = "CREATE TABLE IF NOT EXISTS 1 (\n"
				+ "id INT NOT NULL AUTO_INCREMENT,\n"
				+ "kolumna_1 VARCHAR (255) NULL, \n"
				+ "kolumna_2 DATE NULL, \n" + "kolumna_3 INT (255) NULL, \n"
				+ "kolumna_4 BOOLEAN NULL, \n"
				+ "kolumna_5 VARCHAR (255) NULL, \n"
				+ "kolumna_6 VARCHAR (255) NULL, \n"
				+ "kolumna_7 DATE NULL, \n" + "kolumna_8 INT (255) NULL, \n"
				+ "kolumna_9 BOOLEAN NULL, \n"
				+ "kolumna_10 VARCHAR (255) NULL, \n" + "PRIMARY KEY ( id )\n"
				+ ") CHARSET=utf8;";
		TableDefinition tabelDef = SampleTableDefinitionProvider
				.createSampleTableDefinition(10);
		String actual = SqlBuilder.createOrUpdate(tabelDef);
		assertEquals(expected, actual);
		tabelDef.getColumnList().remove(0);
		assertEquals(expected, actual);
	}

	@Test
	public final void testDeleteTable() {
		String expected = "DROP TABLE tablica_probna ;";
		String actual = SqlBuilder.deleteTable(DataForTests.TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testExistsTable() {
		String expected = "SELECT 1 FROM tablica_probna LIMIT 1 ;";
		String actual = SqlBuilder.existsTable(DataForTests.TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testInsertDataRow() {
		// given
		// TableDefinition td = SampleTableDefinitionProvider
		// .createSampleTableDefinition(1);
		// try {
		// ConnectionStatus.getInstance().getStatement()
		// .executeUpdate(SqlBuilder.createOrUpdate(td));
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		String expected = "INSERT INTO tablica_probna (  )\nVALUES\n( l, k, j );";
		// when
		String actual = SqlBuilder.insertDataRow(SampleTableDefinitionProvider
				.getDataRow(1));
		System.out.println(actual);
		// than
		assertEquals(expected, actual);
	}

	@Test
	public final void testDeleteDataRow() {
		String expected = "DELETE FROM tablica_probna WHERE id=1;";
		String actual = SqlBuilder.deleteDataRow(DataForTests.TABLICA_PROBNA,
				(long) 1);
		assertEquals(expected, actual);
	}

	@Ignore
	@Test
	public final void testGetDataRows() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public final void testUpdateDataRow() {
		fail("Not yet implemented");
	}

	@Ignore
	@AfterClass
	public static void closingDown() {
		LocalhostConnector.closeConnection();
	}

}
