package com.aldina.demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Character {

    private int level;

    public Player(String name, int level, int strength, int intelligence, int agility, int totalHealth, int experience, int baseDamage, int gold) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.totalHealth = totalHealth;
        this.currentHealth = totalHealth;
        this.xp = experience;
        this.baseDamage = baseDamage;
        this.gold = gold;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println(Colors.BLACK_BACKGROUND + Colors.ORANGE + "Level:        " + level + " \t" + Colors.RESET + "\n");
    }

    public void addXp(int xp) {
        this.xp += xp;
    }

    public void levelUp(int gold) {

        int levelsToIncrease = xp / 100;
        int leftoverXp = xp % 100;
        level += levelsToIncrease;
        xp = leftoverXp;

        strength += 2 * levelsToIncrease;
        intelligence += 2 * levelsToIncrease;
        agility += 2 * levelsToIncrease;
        this.gold += gold;

        System.out.println(Colors.YELLOW + "Level up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.PURPLE + "Strength up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.BLUE + "Intelligence up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.GREEN + "Agility up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.GREEN + "Gold: +" + gold + Colors.RESET);

    }

    public boolean flee() {
        if (new Random().nextInt(100) < agility) {
            System.out.println(Colors.ITALICS + "You got away! BUT you can't run away forever..." + Colors.RESET);
            return true;
        } else {
            System.out.println(Colors.ITALICS + "Oh no, you were too slow..." + Colors.RESET);
            return false;
        }
    }
}
