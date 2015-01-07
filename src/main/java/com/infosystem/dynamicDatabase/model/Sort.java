package com.infosystem.dynamicDatabase.model;

public class Sort {
	private String columnId;
	private SortDir direction;

	public Sort(String columnId) {
		super();
		this.columnId = columnId;
		this.direction = SortDir.ASC;
	}

	public Sort(String columnId, SortDir direction) {
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

	protected SortDir getDirection() {
		return direction;
	}

	protected void setDirection(SortDir direction) {
		this.direction = direction;
	}
}
