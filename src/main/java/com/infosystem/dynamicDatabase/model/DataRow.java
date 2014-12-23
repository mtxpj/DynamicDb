package com.infosystem.dynamicDatabase.model;

import java.util.HashMap;
import java.util.Map;

public class DataRow {
    private Long rowId; // identyfikatorWiersz unikalny odpowiada SubmitID
    private String tableId;
    private Map<String, DataHolder> data = new HashMap<String, DataHolder>();

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }
    
    public String getTableId() {
    	return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
    
    public Map<String, DataHolder> getData() {
    	return data;
    }

    public void setData(Map<String, DataHolder> data) {
        this.data = data;
    }

}
