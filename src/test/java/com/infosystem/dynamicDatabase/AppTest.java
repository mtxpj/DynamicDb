package com.infosystem.dynamicDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.methods.DynDataManCheckExist;
import com.infosystem.dynamicDatabase.methods.DynamicDatabaseManagerCommands;
import com.infosystem.dynamicDatabase.methods.SqlBuilder;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private static final String TABLICA_PROBNA = "tablica_probna";

	public static void main(String[] args) throws SQLException {
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLICA_PROBNA);
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < 10; i += 1) {
			ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setDataType(DataType.DATE);
			exampleColumnList.add(i, exampleColumnDefinition);
		}
		tableDefinition.setColumnList(exampleColumnList);

		// connect to database
		LocalhostConnector.openConnection("test");

		// probne komendy
		SqlBuilder komendy = new SqlBuilder();

		// tworzy tabele z TableDefinition
		System.out.println(komendy.create(tableDefinition));
		ConnectionStatus.statement.executeUpdate(komendy.create(tableDefinition));

		
		
		
		// sprawdza czy tabela o zapodanej nazwie istnieje
		if (DynDataManCheckExist.tableExist(ConnectionStatus.connection, TABLICA_PROBNA)) {
			System.out.println("tablica " + TABLICA_PROBNA + " istnieje.");
		} else {
			System.out.println("tablica " + TABLICA_PROBNA + " nie istnieje.");
		}

		// usuwa tabele
		System.out.println(komendy.deleteTable(TABLICA_PROBNA));
		ConnectionStatus.statement.executeUpdate(komendy.deleteTable(TABLICA_PROBNA));

		// sprawdza czy tabela o zapodanej nazwie istnieje
		if (DynDataManCheckExist.tableExist(ConnectionStatus.connection, TABLICA_PROBNA)) {
			System.out.println("tablica " + TABLICA_PROBNA + " istnieje.");
		} else {
			System.out.println("tablica " + TABLICA_PROBNA + " nie istnieje.");
		}

		// close connection
		LocalhostConnector.closeConnection();

	}

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
}
