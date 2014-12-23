package com.infosystem.dynamicDatabase.model;

import java.util.ArrayList;
import java.util.List;

public class TableDefinition {

    private String id;
    private List<ColumnDefinition> columnList = new ArrayList<ColumnDefinition>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ColumnDefinition> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnDefinition> columnList) {
        this.columnList = columnList;
    }

}
