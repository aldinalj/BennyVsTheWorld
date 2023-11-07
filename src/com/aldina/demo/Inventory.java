package com.aldina.demo;

import com.aldina.demo.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Potion> potions;
    private List<Weapon> weapons;

    public Inventory() {
        potions = new ArrayList<>();
        weapons = new ArrayList<>();

    }

    public Inventory(List<Potion> potions, List<Weapon> weapons) {
        this.potions = potions;
        this.weapons = weapons;
    }

    public void showInventory() {

        int potionNumber = 1;

        System.out.println("Potions:");

        for (Potion potion : potions) {
            System.out.println(potionNumber + ". " + potion.getName() + Colors.RESET);
            System.out.print(Colors.RED + "Health +" + potion.getHealth() + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength +" + potion.getStrength() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility +" + potion.getAgility() + Colors.RESET + Colors.RESET);
            System.out.print(Colors.BLUE + " Intelligence +" + potion.getIntelligence() + Colors.RESET);
            System.out.print(Colors.YELLOW + " Price: " + potion.getPrice() + Colors.RESET);
            potionNumber++;
        }

        int weaponNumber = 1;

        System.out.println("Weapons:");

        for (Weapon weapon : weapons) {
            System.out.println(weaponNumber + ". " + weapon.getName() + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength +" + weapon.getStrength() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility +" + weapon.getAgility() + Colors.RESET + Colors.RESET);
            System.out.print(Colors.BLUE + " Intelligence +" + weapon.getIntelligence() + Colors.RESET);
            System.out.print(Colors.YELLOW + " Price: " + weapon.getPrice() + Colors.RESET);
            weaponNumber++;
        }
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void appPotion(Potion potion) {
        potions.add(potion);
    }

}
