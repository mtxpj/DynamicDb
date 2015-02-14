package com.infosystem.dynamicDatabase.model.dto;

public class ColumnLabelDto {
	private String id;
	private int order;
	private String htmlLabel;
	private String plainLabel;

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

}
