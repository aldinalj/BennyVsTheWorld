package com.aldina.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {

    String name;
    int health;
    int strength;
    int agility;
    int intelligence;
    int price;

    public Item(String name, int health, int strength, int agility, int intelligence, int price) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getPrice() {
        return price;
    }

    public List itemList() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Health potion", 50,0,0,0, 50));
        itemList.add(new Item("Strength potion", 0,2,0,0, 50));
        itemList.add(new Item("Agility potion", 0,0,2,0, 50));
        itemList.add(new Item("Intelligence potion", 0,0,0,2, 50));
        itemList.add(new Item("SuperClass potion", 50,2,2,2, 50));

        return itemList;
    }
}
