package com.infosystem.dynamicDatabase.RsultsetManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.model.Null;
import com.infosystem.dynamicDatabase.modelMethods.DataHolderHandler;

public class ResultsetManager {

	public static ColumnDefinition getColumnDefinition(ResultSet rs) {
		ColumnDefinition cd = new ColumnDefinition();
		try {
			cd.setId(rs.getString(2));
			cd.setOrder(rs.getInt(3));
			cd.setColumnDef(Null.valueOf(rs.getString(4)));
			cd.setHtmlLabel(rs.getString(5));
			cd.setPlainLabel(rs.getString(6));
			cd.setDataType(DataType.valueOf(rs.getString(7)));
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
					DataHolder dh = new DataHolder();
					dh.setDataType(DataHolderHandler
							.getDataTypeFromResultSet(rs));
					switch (dh.getDataType()) {
					case STRING:
						dh.setString(rs.getString(i));
						break;
					case DATE:
						dh.setDate(rs.getDate(i));
						break;
					case NUMBER:
						dh.setNumber(rs.getInt(i));
						break;
					case PREDEFINED_VALUE:
						dh.setBool(rs.getBoolean(i));
						break;
					// case SUB_SET:
					// dh.setSubSet(rs.getString(i));// bollocks
					// break;
					default:
						break;
					}
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
