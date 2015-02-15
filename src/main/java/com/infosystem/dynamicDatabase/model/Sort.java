package com.infosystem.dynamicDatabase.model;

public class Sort {
	private String columnId;
	private SortDirection direction;

	public Sort(String columnId) {
		super();
		this.columnId = columnId;
		this.direction = SortDirection.ASC;
	}

	public Sort(String columnId, SortDirection direction) {
		super();
		this.columnId = columnId;
		this.direction = direction;
	}

	protected String getColumnId() {
		return columnId;
	}

	protected void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	protected SortDirection getDirection() {
		return direction;
	}

	protected void setDirection(SortDirection direction) {
		this.direction = direction;
	}
}
