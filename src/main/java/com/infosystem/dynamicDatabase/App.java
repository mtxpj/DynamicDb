package com.infosystem.dynamicDatabase;

import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.LocalhostConnector;
import com.infosystem.dynamicDatabase.methods.Methods;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class App {

	
	public static String DB_NAME = "test";
	public static String TABLE_NAME = "tablica_probna";

	public static void main(String[] args) throws SQLException {

		
		// create sample material
		TableDefinition tableDefinition = CreateSample.createSampleTable();
		
		// connect to database
		LocalhostConnector.openConnection(DB_NAME);

		// pr�bne komendy
		Methods komendy = new Methods();
		
		if (komendy.createOrUpdate(tableDefinition) == null){
			System.out.println("stworzono tablic� " + TABLE_NAME);
		}
		
		if (komendy.existsTable(tableDefinition.getId()) == true){
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		}else{
			System.out.println("tablica o nazwie " + TABLE_NAME + " nie istnieje");
		}
		
		if (komendy.deleteTable(tableDefinition.getId( )) == true){
			System.out.println("tablica o nazwie " + TABLE_NAME + " zosta�a usuni�ta");
		}
		
		if (komendy.existsTable(tableDefinition.getId()) == true){
			System.out.println("tablica o nazwie " + TABLE_NAME + " istnieje");
		}else{
			System.out.println("tablica o nazwie " + TABLE_NAME + " nie istnieje");
		}

		// close connection
		LocalhostConnector.closeConnection();

	}
}
