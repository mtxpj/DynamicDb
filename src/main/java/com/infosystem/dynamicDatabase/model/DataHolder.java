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

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
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
    }

}
