package com.infosystem.dynamicDatabase.RsultsetManager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataType;

public class ResultsetManager {

	public static ColumnDefinition getColumnDefinition(ResultSet rs) {
		ColumnDefinition cd = new ColumnDefinition();
		try {
			cd.setId(rs.getString(2));
			cd.setOrder(rs.getInt(3));
			cd.setColumnDef(rs.getString(4));
			cd.setHtmlLabel(rs.getString(5));
			cd.setPlainLabel(rs.getString(6));
			cd.setDataType(DataType.valueOf(rs.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cd;
	}

}
