package com.aldina.demo;

import java.util.ArrayList;
import java.util.List;

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

    public void showItems(List<Item> itemList) {
        int itemNumber = 1;

        for (Item item : itemList) {
            System.out.println(itemNumber + ". " + item.getName() + Colors.RESET);
            System.out.print(Colors.RED + "Health +" + item.getHealth() + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength +" + item.getStrength() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility +" + item.getAgility() + Colors.RESET + Colors.RESET);
            System.out.print(Colors.BLUE + " Intelligence +" + item.getIntelligence() + Colors.RESET);
            System.out.print(Colors.YELLOW + " Price: " + item.getPrice() + Colors.RESET);

        }







    }
}
