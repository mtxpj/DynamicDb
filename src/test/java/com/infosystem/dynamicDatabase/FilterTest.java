package com.infosystem.dynamicDatabase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.infosystem.dynamicDatabase.methods.SqlFilterBuilder;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.filter.AndFilter;
import com.infosystem.dynamicDatabase.model.filter.Comparator;
import com.infosystem.dynamicDatabase.model.filter.Filter;
import com.infosystem.dynamicDatabase.model.filter.ValueCompareFilter;

public class FilterTest {

	private static final int NUMBER_VAL = 4;
	private static final String LICZBOWA = "liczbowa";
	private static final String WARTOSC_TEKSTOWA = "wartosc%";
	private static final String TEKSTOWA_KOLUMNA = "tekstowaKolumna";
	private static final String EXPECTED_SQL = TEKSTOWA_KOLUMNA + " like '"
			+ WARTOSC_TEKSTOWA + "' AND " + LICZBOWA + " = " + NUMBER_VAL;

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
		System.out.println(EXPECTED_SQL);
		// then
		// tekstowaKolumna like 'wartosc%' AND liczbowa = 4
		Assert.assertEquals(EXPECTED_SQL, actual);

	}

}
