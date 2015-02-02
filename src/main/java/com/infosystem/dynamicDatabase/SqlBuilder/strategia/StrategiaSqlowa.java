package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.model.DataHolder;

public interface StrategiaSqlowa {

	String przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(
			DataHolder dataHolder);

	String przygotujSqlDoTworzeniaKolumny();
	
	DataHolder przygotujDataHolderZResultSet(ResultSet resultSet, int columnNumber) throws SQLException;
}
