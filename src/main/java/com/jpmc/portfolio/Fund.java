package com.jpmc.portfolio;

import java.util.ArrayList;
import java.util.List;

public class Fund {

    String name ;

    int val ;

    List<Fund> children = new ArrayList<Fund>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void addChild(Fund fund){
        children.add(fund);
    }

    public List<Fund> getChildren() {
        return children;
    }
}
