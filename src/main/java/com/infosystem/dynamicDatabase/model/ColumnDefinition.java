package com.infosystem.dynamicDatabase.model;

public class ColumnDefinition {

	private String id;
	private int order;
	private Null columnDef;
	private String htmlLabel;
	private String plainLabel;
	private DataType dataType;

	public ColumnDefinition() {
		super();
	}

	public ColumnDefinition(String id, int order, Null columnDef,
			String htmlLabel, String plainLabel, DataType dataType) {
		super();
		this.id = id;
		this.order = order;
		this.columnDef = columnDef;
		this.htmlLabel = htmlLabel;
		this.plainLabel = plainLabel;
		this.dataType = dataType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Null getColumnDef() {
		return columnDef;
	}

	public void setColumnDef(Null columnDef) {
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
