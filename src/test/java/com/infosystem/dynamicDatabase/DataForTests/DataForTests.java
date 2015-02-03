package com.infosystem.dynamicDatabase.DataForTests;

public class DataForTests {

	final static String LOCALHOST = "";
	private static final String TEST_DB_NAME = "tdd_db";
	private static final String SAMPLE_TABLE = "sample_table_name";
	private static final String COLUMN_ID = "column_name_id";

	public static String getLocalhost() {
		return LOCALHOST;
	}

	public static String getSampleTable() {
		return SAMPLE_TABLE;
	}

	public static String getTestDb() {
		return TEST_DB_NAME;
	}

	public static String getColumnId() {
		return COLUMN_ID;
	}
}
