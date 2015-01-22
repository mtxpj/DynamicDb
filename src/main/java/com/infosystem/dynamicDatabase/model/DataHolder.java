package com.infosystem.dynamicDatabase.model;

import java.util.Date;
import java.util.List;

public class DataHolder {
	private DataType dataType;
	private String string;
	private Date date;
	private Integer number;
	private Boolean bool;
	private List<DataHolder> subSet;

	public DataHolder() {
		super();
	}

	public DataHolder(String string) {
		super();
		setString(string);
	}

	public DataHolder(Date date) {
		super();
		setDate(date);
	}

	public DataHolder(Integer number) {
		super();
		setNumber(number);
	}

	public DataHolder(boolean bool) {
		super();
		setBool(bool);
	}

	public DataHolder(List<DataHolder> subSet) {
		super();
		setSubSet(subSet);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
		this.dataType = DataType.STRING;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		this.dataType = DataType.DATE;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
		this.dataType = DataType.NUMBER;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
		this.dataType = DataType.PREDEFINED_VALUE;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public List<DataHolder> getSubSet() {
		return subSet;
	}

	public void setSubSet(List<DataHolder> subSet) {
		this.subSet = subSet;
		this.dataType = DataType.SUB_SET;
	}

}
