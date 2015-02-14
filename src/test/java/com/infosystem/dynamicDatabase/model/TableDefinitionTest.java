package com.infosystem.dynamicDatabase.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.modelMethods.DynamicDatabaseManagerMethods;

public class TableDefinitionTest {

	private static final String TABLE_ONE = "table_one_id";
	public static final int TABLE_ONE_PRIM_KEY = 1;

	@Test
	public void createNewTableTest() throws SQLException {
		// given
		TableDefinition td = new TableDefinition();
		td.setId(TABLE_ONE);
		List<ColumnDefinition> colDefList = fillColumnDefinitionListWithColumns();
		td.setColumnList(colDefList);
		// when
		MaintainConnection.connectLocalhostWithUserAndPassword(DataForTests
				.getTestDb());
		DynamicDatabaseManagerMethods create = new DynamicDatabaseManagerMethods();
		create.createOrUpdate(td);
		// then
		Assert.assertTrue(create.existsTable(TABLE_ONE));
	}

	private List<ColumnDefinition> fillColumnDefinitionListWithColumns() {
		List<ColumnDefinition> colDefList = new ArrayList<ColumnDefinition>();
		for (int i = 1; i < 10; i++) {
			colDefList.add(createSampleColumnDefinition(i,
					TABLE_ONE_PRIM_KEY));
		}
		return colDefList;
	}

	public static ColumnDefinition createSampleColumnDefinition(int i,
			int table_id) {
		ColumnDefinition colDef = new ColumnDefinition();
		colDef.setId("column_" + i);
		colDef.setOrder(i);
		colDef.setRequired(false);
		colDef.setHtmlLabel("html_label." + i);
		colDef.setPlainLabel("plain_Label." + i);
		colDef.setDataType(DataType.values()[i % 5]);
		colDef.setTable_id(table_id);
		return colDef;
	}

}
