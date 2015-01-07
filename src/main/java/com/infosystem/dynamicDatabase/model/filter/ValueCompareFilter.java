package com.infosystem.dynamicDatabase.model.filter;

import com.infosystem.dynamicDatabase.model.DataHolder;

public class ValueCompareFilter implements Filter {

    private String columnId;
    private Comparator comparator;
    private DataHolder dataHolder;

    public ValueCompareFilter(String columnId, Comparator comparator,
			DataHolder dataHolder) {
		super();
		this.columnId = columnId;
		this.comparator = comparator;
		this.dataHolder = dataHolder;
	}

	public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public DataHolder getDataHolder() {
        return dataHolder;
    }

    public void setDataHolder(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }
}
