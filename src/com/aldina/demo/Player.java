package com.aldina.demo;

import java.util.Scanner;

public class Player {
    private String name;
    private int level;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int xp;
    private int baseDamage;

    public Player(String name, int level, int strength, int intelligence, int agility, int health, int experience, int baseDamage) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.xp = experience;
        this.baseDamage = baseDamage;
    }

    public boolean act() {
        Scanner sc = new Scanner(System.in);
        Monster monster = new Monster();
        System.out.println("What would you like to do?\n1. Attack\n2. Get status\n3. Flee");

        while (true) {
            switch(sc.nextInt()) {
                case 1 -> {
                    attack();
                }
                case 2 -> {
                    showStatus();
                }
                case 3 -> {
                    flee();
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
            if ()
        }
    }

    public void levelUp () {
        int levelsToIncrease = xp / 100;
        int leftoverXp = xp % 100;
        level += levelsToIncrease;
        xp = leftoverXp;
    }

    private void attack() {

    }

    public void showStatus() {
        System.out.println("Status for " + name + ":");
        System.out.println("Level: " + level);
        System.out.println("Experience: " + xp);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Agility: " + agility);
        System.out.println("Health: " + health);
        System.out.println("Base Damage: " + baseDamage);
    }

    private void flee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
