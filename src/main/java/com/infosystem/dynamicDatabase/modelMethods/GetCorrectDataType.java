package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;

public class GetCorrectDataType {
	public static Object getDataTypeFromDataHolder(DataHolder dh) {
		Object data = new Object();
		DataType dt = dh.getDataType();
		switch (dt) {
		case STRING:
			data = dh.getString();
			break;
		case DATE:
			data = dh.getDate();
			break;
		case NUMBER:
			data = dh.getNumber();
			break;
		case PREDEFINED_VALUE:
			data = dh.getBool();
			break;
		case SUB_SET:
			data = dh.getSubSet();
			break;
		default:
			break;
		}
		return data;
	}

	public static DataHolder setAppropriateData(DataHolder dh, DataType dt) {
		// todo
		return dh;
	}

	public static DataType getDataTypeFromResultSet(ResultSet rs) {
		DataType dt = ResultsetManager.getColumnDefinition(rs).getDataType();
		return dt;
	}
}
