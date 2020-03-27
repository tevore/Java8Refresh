package com.lasiossociety.Java8Refresh;

public class Inventory {

    private String name;
    private Integer cost;

    public Inventory(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }
}
