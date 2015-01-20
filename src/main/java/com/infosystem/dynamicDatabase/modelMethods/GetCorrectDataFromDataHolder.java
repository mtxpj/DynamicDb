package com.infosystem.dynamicDatabase.modelMethods;

import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;

public class GetCorrectDataFromDataHolder {
	public static Object getData(DataHolder dh) {
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
}
