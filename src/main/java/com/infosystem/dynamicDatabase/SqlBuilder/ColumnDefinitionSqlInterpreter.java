package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.Null;

public class ColumnDefinitionSqlInterpreter {
	public String getProperSyntax(Null n) {
		String string = new String();
		if (n == Null.NULL) {
			string = "NULL";
		} else {
			string = "NOT NULL";
		}
		return string;
	}
}
