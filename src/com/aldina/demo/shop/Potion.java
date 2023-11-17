package com.aldina.demo.shop;

public class Potion {

    private String name;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;
    private int price;

    public Potion(String name, int health, int strength, int agility, int intelligence, int price) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.price = price;
    }

    public Potion copy() {
        return new Potion(name, health, strength, agility, intelligence, price);
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

}
