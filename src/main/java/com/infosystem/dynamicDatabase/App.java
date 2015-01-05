package com.infosystem.dynamicDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.methods.Methods;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class App {

	public static String DB_NAME = "test";
	public static String TABLE_NAME = "tablica_probna";

	public static void main(String[] args) throws SQLException {

		// hello world
		System.out.println("Hello World and fuck yourself!");

		// create sample material
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId(DB_NAME);

		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();

		for (int i = 0; i < 10; i += 1) {
			ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setDataType(DataType.DATE);
			exampleColumnList.add(i, exampleColumnDefinition);
			System.out.println(exampleColumnList.get(i).getId());
		}

		tableDefinition.setColumnList(exampleColumnList);

		// connect to database
		LocalhostConnector.openConnection("test");

		// probne komendy
		Methods komendy = new Methods();

		if (komendy.createOrUpdate(tableDefinition) == null) {
			System.out.println("stworzono tablicê " + TABLE_NAME);
		}

		if (komendy.existsTable(tableDefinition.getId()) == true) {
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		} else {
			System.out.println("tablica o nazwie " + TABLE_NAME + " nie istnieje");
		}

		if (komendy.deleteTable(tableDefinition.getId()) == true) {
			System.out.println("tablica o nazwie " + TABLE_NAME + " zosta³a usuniêta");
		}

		if (komendy.existsTable(tableDefinition.getId()) == true) {
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		} else {
			System.out.println("tablica o nazwie " + TABLE_NAME + " nie istnieje");
		}

		// close connection
		LocalhostConnector.closeConnection();

	}
}
