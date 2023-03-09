package com.encora.baristamatic.service.impl;

import com.encora.baristamatic.model.Ingredient;
import com.encora.baristamatic.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.encora.baristamatic.constants.BaristamaticConstants.*;

@Service
public class IngredientServiceImpl implements IngredientService {

    //this method have ingredients names and prices
    @Override
    public List<Ingredient> initialIngredients() {

        Ingredient cofeeIngredient = new Ingredient(COFFEE, POINT_SEVEN_FIVE);
        Ingredient decafCofeeIngredient = new Ingredient(DECAF_COFFEE, POINT_SEVEN_FIVE);
        Ingredient sugarIngredient = new Ingredient(SUGAR, POINT_TWO_FIVE);
        Ingredient creamIngredient = new Ingredient(CREAM, POINT_TWO_FIVE);
        Ingredient steamedMilkIngredient = new Ingredient(STEAMED_MILK, POINT_THREE_FIVE);
        Ingredient foamedMilkIngredient = new Ingredient(FOAMED_MILK, POINT_THREE_FIVE);
        Ingredient espressoIngredient = new Ingredient(ESPRESSO, ONE_POINT_ONE_ZERO);
        Ingredient cocoaIngredient = new Ingredient(COCOA, POINT_NINE_ZERO);
        Ingredient whippedCreamIngredient = new Ingredient(WHIPPED_CREAM, ONE_POINT_ZERO_ZERO);

        return List.of(cofeeIngredient, decafCofeeIngredient, sugarIngredient, creamIngredient, steamedMilkIngredient, foamedMilkIngredient, espressoIngredient, cocoaIngredient, whippedCreamIngredient);
    }


}
