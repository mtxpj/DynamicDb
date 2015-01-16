package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.methods.GetCorrectDataFromDataHolder;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;

public class SyntaxCorrector {
	public static String prepareDataForSqlQuery(DataHolder dh) {
		String string = GetCorrectDataFromDataHolder.getData(dh).toString();
		if (dh.getDataType() == DataType.STRING) {
			string = "'" + string + "'";
		}
		return string;
	}
}
