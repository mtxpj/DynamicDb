package com.infosystem.dynamicDatabase.model;

public class Sort {
	private String columnId;
	private SORTDIR direction;

	public Sort(String columnId) {
		super();
		this.columnId = columnId;
		this.direction = SORTDIR.ASC;
	}

	public Sort(String columnId, SORTDIR direction) {
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

	protected SORTDIR getDirection() {
		return direction;
	}

	protected void setDirection(SORTDIR direction) {
		this.direction = direction;
	}
}
