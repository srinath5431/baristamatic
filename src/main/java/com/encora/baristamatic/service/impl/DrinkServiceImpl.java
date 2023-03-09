package com.encora.baristamatic.service.impl;

import com.encora.baristamatic.model.Drink;
import com.encora.baristamatic.model.Inventory;
import com.encora.baristamatic.service.DrinkService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.encora.baristamatic.constants.BaristamaticConstants.*;

@Service
public class DrinkServiceImpl implements DrinkService {


    //this method have drink name and ingredients list to make drink
    @Override
    public List<Drink> drinkList() {

        Drink coffeeDrink = new Drink(COFFEE, List.of(new Inventory(COFFEE, 3), new Inventory(SUGAR, 1), new Inventory(CREAM, 1)));
        Drink decafCoffeeDrink = new Drink(DECAF_COFFEE, List.of(new Inventory(DECAF_COFFEE, 3), new Inventory(SUGAR, 1), new Inventory(CREAM, 1)));
        Drink caffeLatteDrink = new Drink(CAFFE_LATTE, List.of(new Inventory(ESPRESSO, 2), new Inventory(STEAMED_MILK, 1)));
        Drink caffeAmericanoDrink = new Drink(CAFFE_AMERICANO, List.of(new Inventory(ESPRESSO, 3)));
        Drink caffeMochaDrink = new Drink(CAFFE_MOCHA, List.of(new Inventory(ESPRESSO, 1), new Inventory(COCOA, 1), new Inventory(STEAMED_MILK, 1), new Inventory(WHIPPED_CREAM, 1)));
        Drink cappuccinoDrink = new Drink(CAPPUCCINO, List.of(new Inventory(ESPRESSO, 2), new Inventory(STEAMED_MILK, 1), new Inventory(FOAMED_MILK, 1)));

        return List.of(coffeeDrink, decafCoffeeDrink, caffeLatteDrink, caffeAmericanoDrink, caffeMochaDrink, cappuccinoDrink);
    }


}
