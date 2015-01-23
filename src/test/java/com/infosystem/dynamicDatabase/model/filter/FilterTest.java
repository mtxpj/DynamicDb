package com.infosystem.dynamicDatabase.model.filter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.filter.AndFilter;
import com.infosystem.dynamicDatabase.model.filter.Comparator;
import com.infosystem.dynamicDatabase.model.filter.Filter;
import com.infosystem.dynamicDatabase.model.filter.ValueCompareFilter;
import com.infosystem.dynamicDatabase.modelMethods.SqlFilterBuilder;

public class FilterTest {

	private static final int NUMBER_VAL = 4;
	private static final String LICZBOWA = "liczbowa";
	private static final String WARTOSC_TEKSTOWA = "wartosc%";
	private static final String TEKSTOWA_KOLUMNA = "tekstowaKolumna";
	private static final String EXPECTED_AND_FILTER_SQL = Filter.WHERE
			+ TEKSTOWA_KOLUMNA + " LIKE '" + WARTOSC_TEKSTOWA + "' AND "
			+ LICZBOWA + " = " + NUMBER_VAL;
	private static final String EXPECTED_OR_FILTER_SQL = Filter.WHERE
			+ TEKSTOWA_KOLUMNA + " LIKE '" + WARTOSC_TEKSTOWA + "' OR "
			+ LICZBOWA + " = " + NUMBER_VAL;
	private static final String EXPECTED_NOT_FILTER_SQL = Filter.WHERE
			+ NotFilter.NOT + TEKSTOWA_KOLUMNA + " LIKE '" + WARTOSC_TEKSTOWA
			+ "'";

	@Test
	public void shouldProperlyShowAndFilter() {
		// given
		List<Filter> list = new ArrayList<Filter>();
		list.add(new ValueCompareFilter(TEKSTOWA_KOLUMNA, Comparator.LIKE,
				new DataHolder(WARTOSC_TEKSTOWA)));
		list.add(new ValueCompareFilter(LICZBOWA, Comparator.EQ,
				new DataHolder(NUMBER_VAL)));
		AndFilter andFilter = new AndFilter(list);
		// when
		String actual = SqlFilterBuilder.getFilterAsSqlString(andFilter);
		System.out.println(EXPECTED_AND_FILTER_SQL);
		// then
		// tekstowaKolumna like 'wartosc%' AND liczbowa = 4
		Assert.assertEquals(EXPECTED_AND_FILTER_SQL, actual);
	}

	@Test
	public void shouldProperlyShowOrFilter() {
		// given
		List<Filter> list = new ArrayList<Filter>();
		list.add(new ValueCompareFilter(TEKSTOWA_KOLUMNA, Comparator.LIKE,
				new DataHolder(WARTOSC_TEKSTOWA)));
		list.add(new ValueCompareFilter(LICZBOWA, Comparator.EQ,
				new DataHolder(NUMBER_VAL)));
		OrFilter orFilter = new OrFilter(list);
		// when
		String actual = SqlFilterBuilder.getFilterAsSqlString(orFilter);
		System.out.println(EXPECTED_OR_FILTER_SQL);
		// then
		Assert.assertEquals(EXPECTED_OR_FILTER_SQL, actual);
	}

	@Test
	public void shouldProperlyShowNotFilter() {
		// given
		Filter filter = new ValueCompareFilter(TEKSTOWA_KOLUMNA,
				Comparator.LIKE, new DataHolder(WARTOSC_TEKSTOWA));
		NotFilter notFilter = new NotFilter(filter);
		// when
		String actual = SqlFilterBuilder.getFilterAsSqlString(notFilter);
		System.out.println("\n" + EXPECTED_NOT_FILTER_SQL);
		System.out.println(actual);
		// than
		Assert.assertEquals(EXPECTED_NOT_FILTER_SQL, actual);
	}
}
