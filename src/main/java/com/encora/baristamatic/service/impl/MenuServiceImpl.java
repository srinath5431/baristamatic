package com.encora.baristamatic.service.impl;

import com.encora.baristamatic.model.Drink;
import com.encora.baristamatic.model.Ingredient;
import com.encora.baristamatic.model.Inventory;
import com.encora.baristamatic.model.Menu;
import com.encora.baristamatic.service.DrinkService;
import com.encora.baristamatic.service.IngredientService;
import com.encora.baristamatic.service.InventoryService;
import com.encora.baristamatic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.encora.baristamatic.constants.BaristamaticConstants.*;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    DrinkService drinkService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    IngredientService ingredientService;

    private TreeMap<String, Menu> menuMap;

    //this method calculate drink cost and have initial menu data
    @Override
    public List<Menu> menuList() {

        Map<String, List<Inventory>> mapDrinks = drinkService.drinkList().stream().collect(Collectors.toMap(Drink::getName, Drink::getInventoryList));
        Map<String, Float> ingredientMap = ingredientService.initialIngredients().stream().collect(Collectors.toMap(Ingredient::getName, Ingredient::getCost));
        Map<String, Float> drinkCostMap = new HashMap<>();
        for (Map.Entry<String, List<Inventory>> entry : mapDrinks.entrySet()) {
            float drinkCost = 0.0F;
            List<Inventory> inventories = mapDrinks.get(entry.getKey());
            for (Inventory inventory : inventories) {
                drinkCost = drinkCost + inventory.getQuantity() * ingredientMap.get(inventory.getName());
            }
            drinkCostMap.put(entry.getKey(), drinkCost);
        }

        Menu caffeAmericano = new Menu(1, CAFFE_AMERICANO, String.format(PRICE_FORMAT, drinkCostMap.get(CAFFE_AMERICANO)), TRUE);
        Menu caffeLatte = new Menu(2, CAFFE_LATTE, String.format(PRICE_FORMAT, drinkCostMap.get(CAFFE_LATTE)), TRUE);
        Menu caffeMocha = new Menu(3, CAFFE_MOCHA, String.format(PRICE_FORMAT, drinkCostMap.get(CAFFE_MOCHA)), TRUE);
        Menu cappuccino = new Menu(4, CAPPUCCINO, String.format(PRICE_FORMAT, drinkCostMap.get(CAPPUCCINO)), TRUE);
        Menu coffee = new Menu(5, COFFEE, String.format(PRICE_FORMAT, drinkCostMap.get(COFFEE)), TRUE);
        Menu decafCoffee = new Menu(6, DECAF_COFFEE, String.format(PRICE_FORMAT, drinkCostMap.get(DECAF_COFFEE)), TRUE);

        return List.of(caffeAmericano, caffeLatte, caffeMocha, cappuccino, coffee, decafCoffee);
    }

    //this method display initial menu data
    @Override
    public void displayInitialMenu() {

        Map<String, Menu> menuMapData = menuList().stream().collect(Collectors.toMap(Menu::getName, menu -> menu));
        menuMap = new TreeMap<>(menuMapData);
        System.out.println(MENU);
        menuList().forEach(menu -> System.out.println(menu.getId() + COMMA + menu.getName() + COMMA + DOLLAR + menu.getPrice() + COMMA + menu.getAvailability()));
    }


    //this method display menu data after buying drink
    @Override
    public void displayMenu() {
        Map<String, List<Inventory>> mapDrinks = drinkService.drinkList().stream().collect(Collectors.toMap(Drink::getName, Drink::getInventoryList));
        for (Map.Entry<String, List<Inventory>> entry : mapDrinks.entrySet()) {
            List<Inventory> inventories = entry.getValue();
            if (!inventoryService.inStock(inventories)) {
                Menu menu = menuMap.get(entry.getKey());
                menu.setAvailability(FALSE);
                menuMap.put(entry.getKey(), menu);
            }
        }
        System.out.println(MENU);
        for (Map.Entry<String, Menu> entry : menuMap.entrySet()) {
            Menu menu = entry.getValue();
            System.out.println(menu.getId() + COMMA + menu.getName() + COMMA + DOLLAR + menu.getPrice() + COMMA + menu.getAvailability());
        }
    }

}
