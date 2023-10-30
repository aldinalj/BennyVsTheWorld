package com.aldina.demo;

import java.util.Random;

public class Character {
    protected String name;
    protected int level;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int health;
    protected int xp;
    protected int baseDamage;

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

    public void attack(Character character) {
        int damage = calculateDamage();
        // Multiply damage with zero if dodged
        damage *= new Random().nextInt(100) < character.agility ? 0 : 1;
        character.health -= damage;
    }

    private int calculateDamage() {
        // double damage if random int is less than intelligence
        return (baseDamage + strength) * new Random().nextInt(100) < intelligence ? 2 : 1;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getHealth() {
        return health;
    }

    public int getXp() {
        return xp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}
