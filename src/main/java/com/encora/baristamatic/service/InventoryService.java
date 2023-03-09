package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> initialInventory();

    void displayInitialInventory();

    void displayInventory(char input);

    boolean inStock(List<Inventory> inventories);
}
