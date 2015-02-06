package com.infosystem.dynamicDatabase.DataForTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SampleTableDefinitionProvider {
	public static final String TABLICA_PROBNA = "tablica_probna";

	public static TableDefinition createSampleTableDefinition(int colNumber) {
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLICA_PROBNA);
		tableDefinition.setColumnList(getSampleColumnList(colNumber));
		return tableDefinition;
	}

	static List<ColumnDefinition> getSampleColumnList(int colNumber) {
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < colNumber; i += 1) {
			exampleColumnList.add(getSampleColumn(i));
		}
		return exampleColumnList;
	}

	static ColumnDefinition getSampleColumn(int dataSeed) {
		ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
		exampleColumnDefinition.setId("kolumna_" + (dataSeed + 1));
		exampleColumnDefinition.setDataType(getDataType(dataSeed));
		return exampleColumnDefinition;
	}

	static DataType getDataType(int dataSeed) {
		return DataType.values()[dataSeed % DataType.values().length];
	}

	static Map<String, DataHolder> getSampleDataHolder(int colNumber) {
		List<ColumnDefinition> exampleColumnList = getSampleColumnList(colNumber);
		DataType dataType = DataType.STRING;
		DataHolder dataHolder = new DataHolder();
		dataHolder.setDataType(dataType);
		Map<String, DataHolder> data = new HashMap<String, DataHolder>();
		for (int i = 0; i < colNumber; i++) {
			dataHolder.setString("dane " + String.valueOf(i));
			data.put(exampleColumnList.get(i).getId(), dataHolder);
		}
		return data;
	}

	public static DataRow getDataRow(int colNumber) {
		Map<String, DataHolder> data = getSampleDataHolder(colNumber);
		DataRow dataRow = new DataRow();
		dataRow.setRowId((long) 1);
		dataRow.setTableId(TABLICA_PROBNA);
		dataRow.setData(data);
		return dataRow;
	}
}