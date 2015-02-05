package com.infosystem.dynamicDatabase.DataForTests;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.infosystem.dynamicDatabase.CreateSample;
import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class CreateWampDbForTests {

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
		/*
		 * kod przeniesiony z App
		 */

		String TABLE_NAME = "tablica_probna";
		// create sample material
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition = CreateSample.createSampleTable();

		// tworzenie tabeli
		DynamicDatabaseManagerMethods komendy = new DynamicDatabaseManagerMethods();

		if (komendy.createOrUpdate(tableDefinition) == null) {
			System.out.println("stworzono tablicę " + TABLE_NAME);
		}

		if (komendy.existsTable(tableDefinition.getId()) == true) {
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		} else {
			System.out.println("tablica o nazwie " + TABLE_NAME
					+ " nie istnieje");
		}

		// wypełnianie tabeli losowymi liczbami
		for (int i = 0; i < 15; i += 1) {
			DataRow wierszLiczby = CreateSample.fillRowJeden();
			komendy.insertDataRow(wierszLiczby);
		}

		// usuwanie tabeli
		// if (komendy.deleteTable(tableDefinition.getId()) == true) {
		// System.out.println("tablica o nazwie " + TABLE_NAME +
		// " została usunięta");
		// }
		//
		// if (komendy.existsTable(tableDefinition.getId()) == true) {
		// System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		// } else {
		// System.out.println("tablica o nazwie " + TABLE_NAME +
		// " nie istnieje");
		// }

		// close connection
		LocalhostConnector.closeConnection();

	}

}
