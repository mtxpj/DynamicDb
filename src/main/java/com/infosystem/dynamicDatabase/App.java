package com.infosystem.dynamicDatabase;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.methods.DynamicDatabaseManagerCommands;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class App {
	
	
	public static void main(String[] args) throws SQLException {
		
		Statement statement = null;
		
		
		// hello world
		System.out.println("Hello World and fuck yourself!");

		// create sample material
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId("tablica_probna");
		
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();

		for (int i = 0; i < 10; i += 1) {
			ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setColumnDef("something");
			exampleColumnList.add(i, exampleColumnDefinition);
			System.out.println(exampleColumnList.get(i).getId());
		}

		tableDefinition.setColumnList(exampleColumnList);
		

		// connect to database
		LocalhostConnector.openConnection("test");
		
		// probne komendy
		DynamicDatabaseManagerCommands komendy = new DynamicDatabaseManagerCommands();
		System.out.println(komendy.create(tableDefinition));
	
		// close connection
		LocalhostConnector.closeConnection();
		
		
	}
}
