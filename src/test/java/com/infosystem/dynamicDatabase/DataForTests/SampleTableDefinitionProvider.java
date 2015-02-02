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

	public static TableDefinition createSampleTableDefinition() {
		TableDefinition tableDefinition = new TableDefinition();
		tableDefinition.setId(TABLICA_PROBNA);
		tableDefinition.setColumnList(getSampleColumnList());
		return tableDefinition;
	}

	static List<ColumnDefinition> getSampleColumnList() {
		List<ColumnDefinition> exampleColumnList = new ArrayList<ColumnDefinition>();
		for (int i = 0; i < 10; i += 1) {
			exampleColumnList.add(getSampleColumn(exampleColumnList, i));
		}
		return exampleColumnList;
	}

	static ColumnDefinition getSampleColumn(
			List<ColumnDefinition> exampleColumnList, int dataSeed) {
		ColumnDefinition exampleColumnDefinition = new ColumnDefinition();
		exampleColumnDefinition.setId("kolumna_" + (dataSeed + 1));
		exampleColumnDefinition.setDataType(getDataType(dataSeed));
		return exampleColumnDefinition;
	}

	static DataType getDataType(int dataSeed) {
		return DataType.values()[dataSeed % DataType.values().length];
	}

	static Map<String, DataHolder> getSampleDataHolder() {
		List<ColumnDefinition> exampleColumnList = getSampleColumnList();
		DataType dataType = DataType.STRING;
		DataHolder dataHolder = new DataHolder();
		dataHolder.setDataType(dataType);
		Map<String, DataHolder> data = new HashMap<String, DataHolder>();
		for (int i = 0; i < 10; i++) {
			dataHolder.setString("dane " + String.valueOf(i));
			data.put(exampleColumnList.get(i).getId(), dataHolder);
		}
		return data;
	}

	public static DataRow getDataRow() {
		Map<String, DataHolder> data = getSampleDataHolder();
		DataRow dataRow = new DataRow();
		dataRow.setRowId((long) 1);
		dataRow.setTableId(TABLICA_PROBNA);
		dataRow.setData(data);
		return dataRow;
	}
}