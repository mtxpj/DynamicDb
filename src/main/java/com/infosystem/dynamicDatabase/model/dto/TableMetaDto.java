package com.infosystem.dynamicDatabase.model.dto;

import java.util.List;

import com.infosystem.dynamicDatabase.model.ColumnGroup;

public class TableMetaDto {
	private List<ColumnLabelDto> columnsDto;
	private List<ColumnGroup> groups;

	public List<ColumnLabelDto> getColumnsDto() {
		return columnsDto;
	}

	public void setColumnsDto(List<ColumnLabelDto> columnsDto) {
		this.columnsDto = columnsDto;
	}

	public List<ColumnGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<ColumnGroup> groups) {
		this.groups = groups;
	}

}
