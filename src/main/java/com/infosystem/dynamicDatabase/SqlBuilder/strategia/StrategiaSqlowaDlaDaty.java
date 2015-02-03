package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.infosystem.dynamicDatabase.model.DataHolder;

public class StrategiaSqlowaDlaDaty implements StrategiaSqlowa {

	public String przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(
			DataHolder dataHolder) {
		return dataHolder.getDate().toString() + ", ";
	}

	public String przygotujSqlDoTworzeniaKolumny() {
		return "DATE ";
	}

	public DataHolder przygotujDataHolderZResultSet(ResultSet resultSet,
			int columnNumber) throws SQLException {
		DataHolder dataHolder = new DataHolder(resultSet.getDate(columnNumber));
		return dataHolder;
	}

	public Object wyciagnijDaneZDataHoldera(DataHolder dataHolder) {
		return dataHolder.getDate();
	}

	public DataHolder wstawDaneWOdpowiednieMijsceWDataHolderze(Object object) {
		DataHolder dh = new DataHolder();
		dh.setDate((Date) object);
		return dh;
	}

}
