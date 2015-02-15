package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;

import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.SqlBuilder.strategia.FabrykaStrategiiSqlowych;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;

public class DataHolderHandler {

	public static Object getDataFromDataHolder(DataHolder dh) {
		return FabrykaStrategiiSqlowych.getStartegiaSqlowa(dh.getDataType())
				.wyciagnijDaneZDataHoldera(dh);
	}

	public static DataHolder setAppropriateData(Object object, DataType dt) {
		return FabrykaStrategiiSqlowych.getStartegiaSqlowa(dt)
				.wstawDaneWOdpowiednieMijsceWDataHolderze(object);
	}

	public static DataType getDataTypeFromResultSet(ResultSet rs) {
		return ResultsetManager.isRequiredinition(rs).getDataType();
	}
}
