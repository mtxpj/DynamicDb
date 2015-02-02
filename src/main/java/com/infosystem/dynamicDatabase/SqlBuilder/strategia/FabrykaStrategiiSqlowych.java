package com.infosystem.dynamicDatabase.SqlBuilder.strategia;

import com.infosystem.dynamicDatabase.model.DataType;

public class FabrykaStrategiiSqlowych {

	public static StrategiaSqlowa getStartegiaSqlowa(DataType dataType) {
		switch (dataType) {
		case NUMBER:
			return new StartegiaSqlowaNumerowa();
		case DATE:
			return new StrategiaSqlowaDlaDaty();
		case PREDEFINED_VALUE:
			return new StrategiaSqlowaDlaPredefinedValue();
		case STRING:
			return new StrategiaSqlowaDlaStringa();
		case SUB_SET:
			return new StrategiaSqlowaDlaSubSet();
		default:
			break;
		}
		return null;
	}

}
