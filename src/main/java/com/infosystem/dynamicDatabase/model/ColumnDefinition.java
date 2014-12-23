package com.infosystem.dynamicDatabase.model;

public class ColumnDefinition {

    private String id;
    private int order;
    private String columnDef;
    private String htmlLabel;
    private String plainLabel;
    private DataType dataType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public String getHtmlLabel() {
        return htmlLabel;
    }

    public void setHtmlLabel(String htmlLabel) {
        this.htmlLabel = htmlLabel;
    }

    public String getPlainLabel() {
        return plainLabel;
    }

    public void setPlainLabel(String plainLabel) {
        this.plainLabel = plainLabel;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
