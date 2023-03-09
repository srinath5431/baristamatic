package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Menu;
import com.encora.baristamatic.service.impl.DrinkServiceImpl;
import com.encora.baristamatic.service.impl.IngredientServiceImpl;
import com.encora.baristamatic.service.impl.InventoryServiceImpl;
import com.encora.baristamatic.service.impl.MenuServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MenuServiceImplTest {

    @InjectMocks
    MenuServiceImpl menuService;

    @Mock
    InventoryServiceImpl inventoryService;

    @Spy
    IngredientServiceImpl ingredientService;

    @Spy
    DrinkServiceImpl drinkService;

    @Test
    void testMenuList() {
        List<Menu> menuList = menuService.menuList();
        assertEquals(6, menuList.size());
    }

    @Test
    void testDisplayMenu() {
        menuService.displayInitialMenu();
        menuService.displayMenu();
    }
}
