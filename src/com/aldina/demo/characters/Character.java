package com.aldina.demo.characters;
import com.aldina.demo.Colors;

import java.util.Random;



public class Character {
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int currentHealth;
    protected int totalHealth;
    protected int xp;
    protected int baseDamage;
    protected int gold;

    public void showStatus() {
        System.out.println(Colors.BLACK_BACKGROUND + "Status for " + name + ":\t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.RED + "Health:       " + currentHealth + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.GREEN + "Agility:      " + agility + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.BLUE + "Intelligence: " + intelligence + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.PURPLE + "Strength:     " + strength + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.PINK + "Base Damage:  " + baseDamage + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.YELLOW + "Gold:         " +  gold + " \t" + Colors.RESET);
        System.out.println(Colors.BLACK_BACKGROUND + Colors.ORANGE + "Experience:   " + xp + " \t" + Colors.RESET);

    }

    public void attack(Character character) {
        int damage = calculateDamage();
        // Multiply damage with zero if dodged
        if (new Random().nextInt(100) < character.agility) {
            System.out.println(Colors.BLUE + Colors.ITALICS + "Oh... " + character.name + " dodged " + name + "'s attack!\n" + Colors.RESET);
            damage = 0;
        } else {
            System.out.println(Colors.RED + name + " caused " + damage + " damage!\n" + Colors.RESET);
        }
        character.currentHealth -= damage;
    }

    private int calculateDamage() {

        // double damage if random int is less than intelligence
        int damage = baseDamage + strength;
        if (new Random().nextInt(100) < intelligence) {
            damage *= 2;
            System.out.println(Colors.RED_BACKGROUND + Colors.UNDERLINED + "! CRITICAL HIT !" + Colors.RESET);
        }
        return damage;
    }

    public String getName() {
        return name;
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

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getXp() {
        return xp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void restoreHealth() {
        currentHealth = totalHealth;
    }
}
