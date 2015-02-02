package com.infosystem.dynamicDatabase.model.filter;

public class NotFilter implements Filter {
	public final static String NOT = "NOT ";
	
	private Filter filterToBeNegated;

	public NotFilter(Filter filterToBeNegated) {
		super();
		this.filterToBeNegated = filterToBeNegated;
	}

	public Filter getFilterToBeNegated() {
		return filterToBeNegated;
	}

}
