package com.infosystem.dynamicDatabase.methods;

import java.util.List;

import com.infosystem.dynamicDatabase.SqlBuilder.ComparatorInterpreter;
import com.infosystem.dynamicDatabase.SqlBuilder.SyntaxCorrector;
import com.infosystem.dynamicDatabase.model.filter.AndFilter;
import com.infosystem.dynamicDatabase.model.filter.Filter;
import com.infosystem.dynamicDatabase.model.filter.NotFilter;
import com.infosystem.dynamicDatabase.model.filter.OrFilter;
import com.infosystem.dynamicDatabase.model.filter.ValueCompareFilter;

public class SqlFilterBuilder {

	public static String getFilterAsSqlString(AndFilter andFilter) {
		StringBuilder sb = new StringBuilder();
		List<Filter> list = andFilter.getList();
		for (int i = 0; i < list.size(); i++) {
			ValueCompareFilter vcf = (ValueCompareFilter) list.get(i);
			sb.append(vcf.getColumnId());
			sb.append(" ");
			sb.append(ComparatorInterpreter.getString(vcf.getComparator()));
			sb.append(" ");
			sb.append(SyntaxCorrector.prepareDataForSqlQuery(vcf
					.getDataHolder()));
			sb.append(" AND ");
		}
		String str = sb.toString();
		str = str.substring(0, str.lastIndexOf(" AND"));
		sb = new StringBuilder();
		sb.append(str);
		return sb.toString();
	}

	public static String getFilterAsSqlString(NotFilter notFilter0) {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		return sb.toString();
	}

	public static String getFilterAsSqlString(OrFilter orFilter) {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		return sb.toString();
	}

	public static String getFilterAsSqlString(
			ValueCompareFilter valueCompareFilter) {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		return sb.toString();
	}
}
