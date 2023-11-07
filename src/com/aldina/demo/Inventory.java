package com.aldina.demo;
import com.aldina.demo.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Item> items;
    public List<Weapon> weapons;

    public Inventory() {
        items = new ArrayList<>();
        weapons = new ArrayList<>();

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
}
