package com.infosystem.dynamicDatabase.model;

import java.util.List;

import com.infosystem.dynamicDatabase.model.filter.Filter;

public class QueryParams {
    private final String tableId;
    private final int firstResult;
    private final int resultCount;

    private List<String> columnList;
    private List<Sort> sortColumns;
    private Filter filter;

    public QueryParams(String tableId, int firstResult, int resultCount) {
        super();
        this.tableId = tableId;
        this.firstResult = firstResult;
        this.resultCount = resultCount;
    }

    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    public List<String> getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(List<String> sortColumns) {
        this.sortColumns = sortColumns;
    }

    public String getTableId() {
        return tableId;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public int getResultCount() {
        return resultCount;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

}
