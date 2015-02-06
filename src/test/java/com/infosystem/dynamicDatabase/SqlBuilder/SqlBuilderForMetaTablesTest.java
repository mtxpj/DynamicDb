package com.infosystem.dynamicDatabase.SqlBuilder;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilderForMetaTablesTest {

	@Test
	public void testAddNewTableToTablesTable() {
		// given
		TableDefinition td = SampleTableDefinitionProvider
				.createSampleTableDefinition(10);
		String expected = "INSERT INTO all_tables FIELDS (  )" + "\nVALUES"
				+ "\n(  );";
		// when
		String actual = SqlBuilderForMetaTables.addNewTableToTablesTable(td);
		// than
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAddNewColumnsToColumnsTable() {
		// given
		TableDefinition td = SampleTableDefinitionProvider
				.createSampleTableDefinition(10);
		String expected = "INSERT INTO all_columns FIELDS ( name, column_order, column_definition, html_label, plain_label, data_type )"
				+ "\nVALUES\n"
				+ "(kolumna_1, 0, null, null, null, STRING ),\n"
				+ "(kolumna_2, 0, null, null, null, DATE ),\n"
				+ "(kolumna_3, 0, null, null, null, NUMBER ),\n"
				+ "(kolumna_4, 0, null, null, null, PREDEFINED_VALUE ),\n"
				+ "(kolumna_5, 0, null, null, null, SUB_SET ),\n"
				+ "(kolumna_6, 0, null, null, null, STRING ),\n"
				+ "(kolumna_7, 0, null, null, null, DATE ),\n"
				+ "(kolumna_8, 0, null, null, null, NUMBER ),\n"
				+ "(kolumna_9, 0, null, null, null, PREDEFINED_VALUE ),\n"
				+ "(kolumna_10, 0, null, null, null, SUB_SET );";
		// when
		String actual = SqlBuilderForMetaTables.addNewColumnsToColumnsTable(td);
		// than
		Assert.assertEquals(expected, actual);
	}

}
