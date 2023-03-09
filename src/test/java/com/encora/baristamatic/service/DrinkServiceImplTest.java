package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Drink;
import com.encora.baristamatic.service.impl.DrinkServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DrinkServiceImplTest {

    @InjectMocks
    DrinkServiceImpl drinkService;

    @Test
    void testDrinkList() {
        List<Drink> drinkList = drinkService.drinkList();
        assertEquals(6, drinkList.size());
    }
}
