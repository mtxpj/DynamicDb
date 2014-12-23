package com.infosystem.dynamicDatabase;

import java.util.ArrayList;
import java.util.List;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World and fuck yourself!");

		TableDefinition tableDefinition = new TableDefinition();

		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();

		ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
		for (int i = 0; i < 10; i += 1) {
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setColumnDef("something");
			exampleColumnList.add(i, exampleColumnDefinition);
			System.out.println(exampleColumnList.get(i).getId());
		}

		tableDefinition.setColumnList(exampleColumnList);

		List<ColumnDefinition> tempColumnList = tableDefinition.getColumnList();
		for (int i = 0; i < 10; i += 1) {
			System.out.println(tempColumnList.get(i).getId());
		}

	}
}
