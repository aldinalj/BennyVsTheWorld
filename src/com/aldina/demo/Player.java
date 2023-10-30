package com.aldina.demo;

import java.util.Random;
import java.util.Scanner;

public class Player extends Character {
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


    public boolean fight() {
        Scanner sc = new Scanner(System.in);
        Monster monster = new Monster();
        System.out.println("What would you like to do?\n1. Attack\n2. Get status\n3. Flee");

        while (true) {
            switch (sc.nextInt()) {
                case 1 -> {
                    attack(monster);
                    monster.attack(this);
                }
                case 2 -> {
                    showStatus();
                }
                case 3 -> {
                    if (flee()) {
                        return true;
                    }
                    else {
                        monster.attack(this);
                    }
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
            if (health <= 0) return false;
            if (monster.getHealth() <= 0) break;
        }
        levelUp();
        return true;
    }

    private void levelUp() {
        int levelsToIncrease = xp / 100;
        int leftoverXp = xp % 100;
        level += levelsToIncrease;
        xp = leftoverXp;

        strength += 2 * levelsToIncrease;
        intelligence += 2 * levelsToIncrease;
        agility += 2 * levelsToIncrease;
    }

    private boolean flee() {
        return new Random().nextInt(100) < agility;
    }
}
