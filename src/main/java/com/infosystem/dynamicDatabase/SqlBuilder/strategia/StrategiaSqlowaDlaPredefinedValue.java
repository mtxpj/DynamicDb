package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.model.DataHolder;

public class StrategiaSqlowaDlaPredefinedValue implements StrategiaSqlowa {

	public String przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(
			DataHolder dataHolder) {
		return dataHolder.getBool().toString() + ", ";
	}

	public String przygotujSqlDoTworzeniaKolumny() {
		return "VARCHAR (255) ";
	}

	public DataHolder przygotujDataHolderZResultSet(ResultSet resultSet,
			int columnNumber) throws SQLException {
		DataHolder dataHolder = new DataHolder(
				resultSet.getBoolean(columnNumber));
		return dataHolder;
	}

}
