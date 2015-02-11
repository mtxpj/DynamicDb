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
		return "BOOLEAN ";
	}

	public DataHolder przygotujDataHolderZResultSet(ResultSet resultSet,
			int columnNumber) throws SQLException {
		DataHolder dataHolder = new DataHolder(
				resultSet.getBoolean(columnNumber));
		return dataHolder;
	}

	public Object wyciagnijDaneZDataHoldera(DataHolder dataHolder) {
		return dataHolder.getBool();
	}

	public DataHolder wstawDaneWOdpowiednieMijsceWDataHolderze(Object object) {
		DataHolder dh = new DataHolder();
		dh.setBool((Boolean) object);
		return dh;
	}
}
