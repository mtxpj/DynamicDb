package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.modelMethods.GetCorrectDataType;

public class SyntaxCorrector {
	public static String prepareDataForSqlQuery(DataHolder dh) {
		String string = GetCorrectDataType.getDataTypeFromDataHolder(dh)
				.toString();
		if (dh.getDataType() == DataType.STRING) {
			string = "'" + string + "'";
		}
		return string;
	}
}
