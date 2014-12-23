package com.infosystem.dynamicDatabase.model.filter;

import java.util.List;

public class OrFilter implements Filter{

    private List<Filter> list;

    public OrFilter(List<Filter> list) {
        super();
        this.list = list;
    }

    public List<Filter> getList() {
        return list;
    }


}
