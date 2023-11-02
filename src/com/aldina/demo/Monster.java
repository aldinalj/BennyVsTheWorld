package com.aldina.demo;

// import com.sun.security.auth.NTSidDomainPrincipal;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {
    public Monster(String name, int strength, int intelligence, int agility, int totalHealth, int baseDamage, int xp) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.totalHealth = totalHealth;
        this.currentHealth = totalHealth;
        this.baseDamage = baseDamage;
        this.xp = xp;
    }

    public static List<Monster> generateMonsters() {

        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster("Anton", 13, 13, 13, 50,2, 50));
        monsterList.add(new Monster("Sidon", 13, 13, 13, 50,2, 50));
        monsterList.add(new Monster("Nabooru", 13, 13, 13, 50,2, 50));
        monsterList.add(new Monster("Pudge", 13, 13, 13, 50, 2,50));
        //monsterList.add(new Monster("Krille", 13, 13, 13, 50,2,50));

        return monsterList;
    }
}

