package com.infosystem.dynamicDatabase.RsultsetManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.SqlBuilder.strategia.FabrykaStrategiiSqlowych;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.modelMethods.DataHolderHandler;

public class ResultsetManager {

	public static ColumnDefinition isRequiredinition(ResultSet rs) {
		ColumnDefinition cd = new ColumnDefinition();
		try {
			if (rs.next()) {
				cd.setTable_id(1);
				cd.setId(rs.getString(2));
				cd.setOrder(rs.getInt(3));
				cd.setRequired(rs.getBoolean(4));
				cd.setHtmlLabel(rs.getString(5));
				cd.setPlainLabel(rs.getString(6));
				cd.setDataType(DataType.valueOf(rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cd;
	}

	public static List<DataRow> getRowsFromResultSet(ResultSet rs,
			List<String> columnList) {
		List<DataRow> dataRowList = new ArrayList<DataRow>();
		try {
			while (rs.next()) {
				DataRow dataRow = new DataRow();
				Map<String, DataHolder> data = new HashMap<String, DataHolder>();
				for (int i = 1; i < columnList.size(); i++) {
					DataType dt = DataHolderHandler
							.getDataTypeFromResultSet(rs);
					DataHolder dh = FabrykaStrategiiSqlowych
							.getStartegiaSqlowa(dt)
							.przygotujDataHolderZResultSet(rs, i);
					data.put(columnList.get(i), dh);
				}
				dataRow.setData(data);
				dataRowList.add(dataRow);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataRowList;
	}
}
