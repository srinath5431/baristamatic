package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Inventory;
import com.encora.baristamatic.service.impl.DrinkServiceImpl;
import com.encora.baristamatic.service.impl.InventoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InventoryServiceImplTest {

    @InjectMocks
    InventoryServiceImpl inventoryService;

    @Spy
    DrinkServiceImpl drinkService;

    @Test
    void testInitialInventory() {
        List<Inventory> inventoryList = inventoryService.initialInventory();
        assertEquals(9, inventoryList.size());
    }

    @Test
    void testDisplayInventory() {
        inventoryService.displayInitialInventory();
        inventoryService.displayInventory('1');
        inventoryService.displayInventory('2');
        inventoryService.displayInventory('3');
        inventoryService.displayInventory('4');
        inventoryService.displayInventory('5');
        inventoryService.displayInventory('6');
    }
}
