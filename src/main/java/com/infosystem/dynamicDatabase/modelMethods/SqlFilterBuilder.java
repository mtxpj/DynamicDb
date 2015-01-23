package com.infosystem.dynamicDatabase.modelMethods;

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
		sb.append(Filter.WHERE);
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

	public static String getFilterAsSqlString(OrFilter orFilter) {
		StringBuilder sb = new StringBuilder();
		sb.append(Filter.WHERE);
		List<Filter> list = orFilter.getList();
		for (int i = 0; i < list.size(); i++) {
			ValueCompareFilter vcf = (ValueCompareFilter) list.get(i);
			sb.append(vcf.getColumnId());
			sb.append(" ");
			sb.append(ComparatorInterpreter.getString(vcf.getComparator()));
			sb.append(" ");
			sb.append(SyntaxCorrector.prepareDataForSqlQuery(vcf
					.getDataHolder()));
			sb.append(" OR ");
		}
		String str = sb.toString();
		str = str.substring(0, str.lastIndexOf(" OR"));
		sb = new StringBuilder();
		sb.append(str);
		return sb.toString();
	}

	public static String getFilterAsSqlString(NotFilter notFilter) {
		StringBuilder sb = new StringBuilder();
		sb.append(Filter.WHERE);
		Filter filter = notFilter.getFilterToBeNegated();
		sb.append(NotFilter.NOT);
		ValueCompareFilter vcf = (ValueCompareFilter) filter;
		sb.append(vcf.getColumnId());
		sb.append(" ");
		sb.append(ComparatorInterpreter.getString(vcf.getComparator()));
		sb.append(" ");
		sb.append(SyntaxCorrector.prepareDataForSqlQuery(vcf
				.getDataHolder()));
		return sb.toString();
	}

	public static String getFilterAsSqlString(
			ValueCompareFilter valueCompareFilter) {
		StringBuilder sb = new StringBuilder();
		sb.append(Filter.WHERE);
		sb.append("");
		return sb.toString();
	}

	public static String getFilterAsSqlString(Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
