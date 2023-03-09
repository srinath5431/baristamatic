package com.encora.baristamatic.model;

import java.util.List;

public class Drink {

    private String name;
    private List<Inventory> inventoryList;

    public Drink(String name, List<Inventory> inventoryList) {
        this.name = name;
        this.inventoryList = inventoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
