package com.infosystem.dynamicDatabase.methods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderTest {
	private static final String TABLICA_PROBNA = "tablica_probna";
	private static TableDefinition tableDefinition;
	private static DataRow dataRow;
	private static DataHolder dataHolder;
	private static ColumnDefinition exampleColumnDefinition;

	@BeforeClass
	public static void oneTimeSetUp() {
		tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLICA_PROBNA);
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < 10; i += 1) {
			exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setDataType(DataType.STRING);
			exampleColumnList.add(i, exampleColumnDefinition);
		}
		tableDefinition.setColumnList(exampleColumnList);

		DataType dataType = DataType.STRING;
		dataHolder = new DataHolder();
		dataHolder.setDataType(dataType);
		Map<String, DataHolder> data = new HashMap<String, DataHolder>();
		for (int i = 0; i < 5; i++) { // każdy submit ma dane dla 5 kolumn
			dataHolder.setString("dane " + i);
			data.put(exampleColumnList.get(i).getId(), dataHolder);
		}
		dataRow = new DataRow();
		dataRow.setRowId((long) 1);
		dataRow.setTableId(TABLICA_PROBNA);
		dataRow.setData(data);
	}

	@Test
	public final void testCreate() {
		String expected = "CREATE TABLE tablica_probna (\n" + "id INT NOT NULL AUTO_INCREMENT, \n" + "kolumna_1 DATE null, \n"
				+ "kolumna_2 DATE null, \n" + "kolumna_3 DATE null, \n" + "kolumna_4 DATE null, \n" + "kolumna_5 DATE null, \n"
				+ "kolumna_6 DATE null, \n" + "kolumna_7 DATE null, \n" + "kolumna_8 DATE null, \n" + "kolumna_9 DATE null, \n"
				+ "kolumna_10 DATE null, \n" + "PRIMARY KEY ( id )\n" + ");";
		String actual = SqlBuilder.createOrUpdate(tableDefinition);
		assertEquals(expected, actual);
	}

	@Test
	public final void testDeleteTable() {
		String expected = "DROP TABLE tablica_probna";
		String actual = SqlBuilder.deleteTable(TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testExistsTable() {
		String expected = "SELECT 1 FROM tablica_probna LIMIT 1";
		String actual = SqlBuilder.existsTable(TABLICA_PROBNA);
		assertEquals(expected, actual);
	}

	@Test
	public final void testInsertDataRow() {
		String expected = "INSERT INTO tablica_probna (  )\nVALUES\n( l, k, j )";
		String actual = SqlBuilder.insertDataRow(dataRow);
		System.out.println(actual); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		assertEquals(expected, actual);
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

	@AfterClass
	public static void closingDown() {
		// LocalhostConnector.closeConnection();
	}

}
