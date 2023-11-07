package com.aldina.demo.weapons;

public class Spear implements Weapon {

    private String name;
    private int damage;
    private int agility;
    private int strength;
    private int intelligence;
    private int price;

    public Spear (String name, int damage, int agility, int strength, int intelligence, int price) {
        this.name = name;
        this.damage = damage;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;
        this.price = price;

    }

    public void displayInfo() {
        System.out.println("Weapon Name: " + getName());
        System.out.println("Damage: " + getDamage());
        System.out.println("Agility Bonus: " + getAgility());
        System.out.println("Strength Bonus: " + getStrength());
        System.out.println("Intelligence Bonus: " + getIntelligence());
        System.out.println("Price: " + getPrice());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void attack() {
        System.out.println("Spear lunged!");
    }

    @Override
    public Weapon copy() {
        return new Spear(name, damage, agility, strength, intelligence, price);
    }
}





