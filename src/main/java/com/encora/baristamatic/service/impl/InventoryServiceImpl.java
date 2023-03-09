package com.encora.baristamatic.service.impl;

import com.encora.baristamatic.model.Drink;
import com.encora.baristamatic.model.Inventory;
import com.encora.baristamatic.service.DrinkService;
import com.encora.baristamatic.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.encora.baristamatic.constants.BaristamaticConstants.*;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    DrinkService drinkService;

    private TreeMap<String, Integer> inventoryMap;

    //this method have ingredients and initial quantity in inventory
    @Override
    public List<Inventory> initialInventory() {

        Inventory cofeeInventory = new Inventory(COFFEE, 10);
        Inventory decafCoffeeInventory = new Inventory(DECAF_COFFEE, 10);
        Inventory sugarInventory = new Inventory(SUGAR, 10);
        Inventory creamInventory = new Inventory(CREAM, 10);
        Inventory steamedMilkInventory = new Inventory(STEAMED_MILK, 10);
        Inventory foamedMilkInventory = new Inventory(FOAMED_MILK, 10);
        Inventory espressoInventory = new Inventory(ESPRESSO, 10);
        Inventory cocoaInventory = new Inventory(COCOA, 10);
        Inventory whippedCreamInventory = new Inventory(WHIPPED_CREAM, 10);

        return List.of(cofeeInventory, decafCoffeeInventory, sugarInventory, creamInventory, steamedMilkInventory, foamedMilkInventory, espressoInventory, cocoaInventory, whippedCreamInventory);
    }

    //this method display initial inventory data
    @Override
    public void displayInitialInventory() {
        Map<String, Integer> inventoryMapData = initialInventory().stream().collect(Collectors.toMap(Inventory::getName, Inventory::getQuantity));
        inventoryMap = new TreeMap<>(inventoryMapData);
        System.out.println(INVENTORY);
        initialInventory().forEach(inventory -> System.out.println(inventory.getName() + COMMA + inventory.getQuantity()));
    }

    //this method display inventory data after buying drink
    @Override
    public void displayInventory(char input) {

        switch (input) {
            case '1': {
                updateInventory(CAFFE_AMERICANO);
                break;
            }
            case '2': {
                updateInventory(CAFFE_LATTE);
                break;
            }
            case '3': {
                updateInventory(CAFFE_MOCHA);
                break;
            }
            case '4': {
                updateInventory(CAPPUCCINO);
                break;
            }
            case '5': {
                updateInventory(COFFEE);
                break;
            }
            default: {
                updateInventory(DECAF_COFFEE);
                break;
            }
        }
    }

    //this method update inventory data after buying drink
    private void updateInventory(String drinkName) {
        Map<String, List<Inventory>> mapDrinks = drinkService.drinkList().stream().collect(Collectors.toMap(Drink::getName, Drink::getInventoryList));
        List<Inventory> inventories = mapDrinks.get(drinkName);
        if (Boolean.TRUE.equals(inStock(inventories))) {
            System.out.println(DISPENSING + drinkName);
            inventories.forEach(inventory -> inventoryMap.put(inventory.getName(), inventoryMap.get(inventory.getName()) - inventory.getQuantity()));
        } else {
            System.err.println(OUT_OF_STOCK + drinkName);
        }
        System.out.println(INVENTORY);
        for (Map.Entry<String, Integer> entry : inventoryMap.entrySet())
            System.out.println(entry.getKey() + COMMA + entry.getValue());
    }

    //this method check inventory data before dispense drink and before display menu
    @Override
    public boolean inStock(List<Inventory> inventories) {
        int i = 0;
        for (Inventory inventory : inventories) {
            if (inventoryMap.get(inventory.getName()) >= inventory.getQuantity())
                i++;
        }
        return inventories.size() == i;
    }

}
