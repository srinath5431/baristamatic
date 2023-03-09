package com.encora.baristamatic;

import com.encora.baristamatic.service.InventoryService;
import com.encora.baristamatic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.encora.baristamatic.constants.BaristamaticConstants.INVALID_SELECTION;

@SpringBootApplication
public class BaristamaticApplication implements CommandLineRunner {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    MenuService menuService;

    public static void main(String[] args) {
        SpringApplication.run(BaristamaticApplication.class, args);
    }

    @Override
    public void run(String... args) {

        inventoryService.displayInitialInventory();
        menuService.displayInitialMenu();
        boolean quit = false;
        while (!quit) {
            Scanner scanner = new Scanner(System.in);
            char input = scanner.nextLine().toLowerCase().charAt(0);

            switch (input) {
                case 'r':
                    inventoryService.displayInitialInventory();
                    menuService.displayInitialMenu();
                    break;
                case 'q':
                    quit = true;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                    inventoryService.displayInventory(input);
                    menuService.displayMenu();
                    break;
                default:
                    System.err.println(INVALID_SELECTION + input);
                    break;

            }
        }
    }
}
