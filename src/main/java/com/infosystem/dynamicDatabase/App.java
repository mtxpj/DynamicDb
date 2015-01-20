package com.infosystem.dynamicDatabase;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class App {

	public static String DB_NAME = "test";
	public static String TABLE_NAME = "tablica_probna";

	public static void main(String[] args) throws SQLException {

		// hello world
		System.out.println("Hello World");

		// create sample material
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition = CreateSample.createSampleTable();

		// connect to database
		LocalhostConnector.openConnection(DB_NAME);

		// tworzenie tabeli
		DynamicDatabaseManagerMethods komendy = new DynamicDatabaseManagerMethods();

		if (komendy.createOrUpdate(tableDefinition) == null) {
			System.out.println("stworzono tablicę " + TABLE_NAME);
		 }

		if (komendy.existsTable(tableDefinition.getId()) == true) {
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		} else {
			System.out.println("tablica o nazwie " + TABLE_NAME + " nie istnieje");
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
