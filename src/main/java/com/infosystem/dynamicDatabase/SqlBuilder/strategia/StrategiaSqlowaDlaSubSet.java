package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.model.DataHolder;

public class StrategiaSqlowaDlaSubSet implements StrategiaSqlowa {

	public String przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(
			DataHolder dataHolder) {
		return dataHolder.getSubSet().toString() + ", ";
	}

	public String przygotujSqlDoTworzeniaKolumny() {
		return "VARCHAR (255) ";
	}

	public DataHolder przygotujDataHolderZResultSet(ResultSet resultSet,
			int columnNumber) throws SQLException {
		DataHolder dataHolder = new DataHolder(
				resultSet.getString(columnNumber));
		return dataHolder;
	}

}
