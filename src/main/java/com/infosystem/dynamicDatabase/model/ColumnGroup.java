package com.infosystem.dynamicDatabase.model;

import java.util.List;

public class ColumnGroup {
	private Long id;
	private String htmlLabel;
	private String plainLabel;
	private List<String> groupedColumns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getGroupedColumns() {
		return groupedColumns;
	}

	public void setGroupedColumns(List<String> groupedColumns) {
		this.groupedColumns = groupedColumns;
	}

}
