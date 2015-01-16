package com.infosystem.dynamicDatabase.SqlBuilder;

import com.infosystem.dynamicDatabase.model.filter.Comparator;

public class ComparatorInterpreter {

	public static String getString(Comparator comp) {
		return comparatorSwitch(comp);
	}

	private static String comparatorSwitch(Comparator comp) {
		String string = new String();
		switch (comp) {
		case ENDS_WITH:
			string = "END"; // spr
			break;
		case EQ:
			string = "=";
			break;
		case GT:
			string = ">";
			break;
		case GTE:
			string = ">=";
			break;
		case LIKE:
			string = "LIKE";
			break;
		case LT:
			string = "<";
			break;
		case LTE:
			string = "<=";
			break;
		case STARTS_WITH:
			string = "BEGIN"; // spr
			break;
		}
		return string;
	}

}
