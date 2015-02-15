package com.infosystem.dynamicDatabase.model;

import java.util.List;

public class ColumnDefinition {

	private String id;
	private int order;
	private String groupId;
	private boolean required; // true = NOT NULL, false = NULL
	private String htmlLabel;
	private String plainLabel;
	private DataType dataType;
	private int table_id;
	private List<DictionaryValue> dictionaryValues;

	public ColumnDefinition(String id, int order, boolean required,
			String htmlLabel, String plainLabel, DataType dataType) {
		super();
		this.id = id;
		this.order = order;
		this.required = required;
		this.htmlLabel = htmlLabel;
		this.plainLabel = plainLabel;
		this.dataType = dataType;
	}

	public ColumnDefinition() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
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

	public int getTable_id() {
		return table_id;
	}

	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<DictionaryValue> getDictionaryValues() {
		return dictionaryValues;
	}

	public void setDictionaryValues(List<DictionaryValue> dictionaryValues) {
		this.dictionaryValues = dictionaryValues;
	}
	
}
