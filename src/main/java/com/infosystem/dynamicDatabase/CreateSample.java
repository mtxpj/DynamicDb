package com.infosystem.dynamicDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class CreateSample {
	public static String TABLE_NAME = "tablica_probna";

	public static TableDefinition createSampleTable() {
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLE_NAME);
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < 10; i += 1) {
			ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
			exampleColumnDefinition.setId("kolumna_" + (i + 1));
			exampleColumnDefinition.setDataType(DataType.NUMBER);
			exampleColumnList.add(i, exampleColumnDefinition);
		}
		tableDefinition.setColumnList(exampleColumnList);
		return tableDefinition;
	}

	public static DataRow fillRowJeden() {
		// wiersz jeden
		Map<String, DataHolder> dataJeden = new HashMap<String, DataHolder>();
		for (int i = 0; i < 10; i += 1) {
			Random random = new Random();
			int val = random.nextInt(100);
			DataHolder dataHolder = new DataHolder();
			dataHolder.setDataType(DataType.NUMBER);
			dataHolder.setNumber(val);
			dataJeden.put(("kolumna_" + (i + 1)), dataHolder);
		}
		DataRow wierszJeden = new DataRow();
		wierszJeden.setTableId(TABLE_NAME);
		wierszJeden.setRowId((long) 1);
		wierszJeden.setData(dataJeden);
		return wierszJeden;
	}

	public static DataRow fillRowDwa() {
		// wiersz dwa
		Map<String, DataHolder> dataDwa = new HashMap<String, DataHolder>();
		for (int i = 0; i < 10; i += 1) {
			DataHolder dataHolder = new DataHolder();
			dataHolder.setDataType(DataType.STRING);
			dataHolder.setString("zawartosc " + i);
			dataDwa.put(("kolumna_" + (i + 1)), dataHolder);
		}
		DataRow wierszDwa = new DataRow();
		wierszDwa.setTableId(TABLE_NAME);
		wierszDwa.setRowId((long) 2);
		wierszDwa.setData(dataDwa);
		return wierszDwa;
	}

	// wiersz trzy

	// DataRow wierszTrzy = new DataRow();
	//
	// Map<String, DataHolder> dataTrzy = new HashMap<String, DataHolder>();
	// for (int i=0; i<10; i+=1){
	// DataHolder dataHolder = new DataHolder();
	// dataHolder.setDataType(DataType.SUB_SET);
	//
	// List<DataHolder> subSet = new ArrayList<DataHolder>();
	// for (int j =0; j<3; j+=1){
	// DataHolder dh = new DataHolder();
	// dh.setDataType(DataType.NUMBER);
	// dh.setNumber(i);
	// subSet.set(i, dh);
	// }
	//
	// dataHolder.setSubSet(subSet);
	// dataTrzy.put(("kolumna_"+(i+1)), dataHolder);
	// }
	//
	// wierszTrzy.setTableId(App.TABLE_NAME);
	// wierszTrzy.setRowId((long) 5);
	// wierszTrzy.setData(dataTrzy);

}
