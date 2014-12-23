package com.infosystem.dynamicDatabase.model.filter;

import java.util.List;

public class AndFilter implements Filter{

    private List<Filter> list;

    public AndFilter(List<Filter> list) {
        super();
        this.list = list;
    }

    public List<Filter> getList() {
        return list;
    }


}
