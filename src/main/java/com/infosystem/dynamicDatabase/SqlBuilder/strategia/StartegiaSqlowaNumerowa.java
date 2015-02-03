package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.model.DataHolder;

public class StartegiaSqlowaNumerowa implements StrategiaSqlowa {
	public String przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(
			DataHolder dataHolder) {
		return dataHolder.getNumber().toString() + ", ";
	}

	public String przygotujSqlDoTworzeniaKolumny() {
		return "INT (255) ";
	}

	public DataHolder przygotujDataHolderZResultSet(ResultSet resultSet,
			int columnNumber) throws SQLException {
		DataHolder dataHolder = new DataHolder(resultSet.getInt(columnNumber));
		return dataHolder;
	}

	public Object wyciagnijDaneZDataHoldera(DataHolder dataHolder) {
		return dataHolder.getNumber();
	}

	public DataHolder wstawDaneWOdpowiednieMijsceWDataHolderze(Object object) {
		DataHolder dh = new DataHolder();
		dh.setNumber((Integer) object);
		return dh;
	}

}
