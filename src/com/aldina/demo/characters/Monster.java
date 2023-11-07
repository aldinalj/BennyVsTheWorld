package com.aldina.demo.characters;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {
    public Monster(String name, int strength, int intelligence, int agility, int totalHealth, int baseDamage, int xp, int gold) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.totalHealth = totalHealth;
        this.currentHealth = totalHealth;
        this.baseDamage = baseDamage;
        this.xp = xp;
        this.gold = gold;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println();
    }

    public static List<Monster> generateMonsters() {

        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster("Anton", 13, 13, 13, 50,2, 50, 50));
        monsterList.add(new Monster("Sidon", 13, 13, 13, 50,2, 50, 50));
        monsterList.add(new Monster("Nabooru", 13, 13, 13, 50,2, 50, 50));
        monsterList.add(new Monster("Pudge", 13, 13, 13, 50, 2,50, 50));
        monsterList.add(new Monster("Herobrine", 13, 13, 13, 50, 2,50, 50));
        monsterList.add(new Monster("Bowser", 13, 13, 13, 50, 2,50, 50));

        return monsterList;
    }
}

