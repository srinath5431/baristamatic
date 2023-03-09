package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Ingredient;
import com.encora.baristamatic.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IngredientServiceImplTest {

    @InjectMocks
    IngredientServiceImpl ingredientService;

    @Test
    void testInitialIngredients() {
        List<Ingredient> ingredientList = ingredientService.initialIngredients();
        assertEquals(9, ingredientList.size());
    }
}
