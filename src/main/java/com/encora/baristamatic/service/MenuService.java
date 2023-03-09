package com.encora.baristamatic.service;

import com.encora.baristamatic.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> menuList();

    void displayInitialMenu();

    void displayMenu();
}
