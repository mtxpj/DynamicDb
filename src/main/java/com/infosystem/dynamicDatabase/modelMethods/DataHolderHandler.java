package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;

public class DataHolderHandler {
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

	@SuppressWarnings("unchecked")
	public static DataHolder setAppropriateData(Object object, DataType dt) {
		DataHolder dh = new DataHolder();
		switch (dt) {
		case STRING:
			dh.setString((String) object);
			break;
		case DATE:
			dh.setDate((Date) object);
			break;
		case NUMBER:
			dh.setNumber((Integer) object);
			break;
		case PREDEFINED_VALUE:
			dh.setBool((Boolean) object);
			break;
		case SUB_SET:
			dh.setSubSet((List<DataHolder>) object);
			break;
		default:
			break;
		}
		return dh;
	}

	public static DataType getDataTypeFromResultSet(ResultSet rs) {
		DataType dt = ResultsetManager.getColumnDefinition(rs).getDataType();
		return dt;
	}
}
