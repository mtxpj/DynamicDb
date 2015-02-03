package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataType;
import com.infosystem.dynamicDatabase.modelMethods.DataHolderHandler;

public class SyntaxCorrector {
	public static String prepareDataForSqlQuery(DataHolder dh) {
		String string = DataHolderHandler.getDataFromDataHolder(dh)
				.toString();
		if (dh.getDataType() == DataType.STRING) {
			string = "'" + string + "'";
		}
		return string;
	}
}
