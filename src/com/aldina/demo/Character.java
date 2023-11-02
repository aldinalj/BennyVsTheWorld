package com.aldina.demo;
import java.util.Random;



public class Character {
    protected String name;
    protected int level;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int currentHealth;
    protected int totalHealth;
    protected int xp;
    protected int baseDamage;


    public void showStatus() {
        System.out.println(Colors.BLACK_BACKGROUND + "Status for " + name + ":" + Colors.RESET);
        System.out.println(Colors.RED + "Health:       " + currentHealth + Colors.RESET);
        System.out.println(Colors.GREEN + "Agility:      " + agility + Colors.RESET);
        System.out.println(Colors.BLUE + "Intelligence: " + intelligence + Colors.RESET);
        System.out.println(Colors.PURPLE + "Strength:     " + strength + Colors.RESET);
        System.out.println(Colors.WHITE + "Base Damage:  " + baseDamage + Colors.RESET);
        System.out.println(Colors.YELLOW_BOLD + "Level:        " + level + Colors.RESET);
        System.out.println(Colors.YELLOW + "Experience:   " + xp + Colors.RESET + "\n");



    }

    public void attack(Character character) {
        int damage = calculateDamage();
        // Multiply damage with zero if dodged
        if (new Random().nextInt(100) < character.agility) {
            System.out.println(Colors.ITALICS + "Oh... " + character.name + " dodged " + name + "'s attack!\n" + Colors.RESET);
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
            System.out.println(Colors.RED_BACKGROUND + "! CRITICAL HIT !" + Colors.RESET);
        }
        return damage;
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

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getXp() {
        return xp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
    public void restoreHealth() {
        currentHealth = totalHealth;
    }
}
