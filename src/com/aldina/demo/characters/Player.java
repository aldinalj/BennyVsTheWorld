package com.aldina.demo.characters;

import com.aldina.demo.text.Colors;
import com.aldina.demo.text.InputHandler;
import com.aldina.demo.Inventory;
import com.aldina.demo.shop.Potion;
import com.aldina.demo.shop.weapons.Fists;

import java.util.Random;

public class Player extends Character {

    private int level;
    private Inventory inventory;

    public Player(String name, int level, int strength, int intelligence, int agility, int totalHealth, int experience, int baseDamage, int gold) {
        this.inventory = new Inventory();
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
        this.equippedWeapon = new Fists("Fists",0);
        this.inventory.addWeapon(equippedWeapon);
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

        System.out.println(Colors.ORANGE + "Level up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.PURPLE + "Strength up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.BLUE + "Intelligence up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.GREEN + "Agility up: +" + (levelsToIncrease * 2) + Colors.RESET);
        System.out.println(Colors.YELLOW + "Gold: +" + gold + Colors.RESET);

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

    public Inventory getInventory() {
        return inventory;
    }
    public void equipWeapon() {

        InputHandler in = new InputHandler();

        inventory.showWeapons();

        System.out.println("0. Go back");

        System.out.println("Which weapon would you like to equip?");
        System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);

        while (true) {
            int weaponChoice = (in.takeNumber() - 1);
            if (weaponChoice >= 0 && weaponChoice < inventory.getWeapons().size()) {
                equippedWeapon = inventory.getWeapons().get(weaponChoice);
                System.out.println(equippedWeapon.getName() + " is equipped!\n");
                return;
            } else if (weaponChoice == -1) {
                return;
            } else {
                System.out.println(Colors.BOLD + Colors.RED + "⚠ Did your fingers slip?..." + Colors.RESET);
            }
        }
    }
    public void usePotion() {
        InputHandler in = new InputHandler();

        inventory.showPotions();

        System.out.println("0. Go back");

        System.out.println("Which potion would you like to consume?");
        System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);

        while (true) {
            int potionChoice = (in.takeNumber() - 1);
            if (potionChoice >= 0 && potionChoice < inventory.getPotions().size()) {

                Potion selectedPotion = inventory.getPotions().get(potionChoice);

                currentHealth += selectedPotion.getHealth();
                agility += selectedPotion.getAgility();
                intelligence += selectedPotion.getIntelligence();
                strength += selectedPotion.getStrength();

                System.out.println(selectedPotion.getName() + " is consumed!\n");

                inventory.removePotion(selectedPotion);
                return;
            } else if (potionChoice == -1) {
                return;
            } else {
                System.out.println(Colors.BOLD + Colors.RED + "⚠ Did your fingers slip?..." + Colors.RESET);
            }
        }

    }

    public int getLevel() {
        return level;
    }
}
