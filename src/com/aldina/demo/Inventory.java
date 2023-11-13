package com.aldina.demo;

import com.aldina.demo.text.Colors;
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
        showWeapons();
        showPotions();
    }

    public void showWeapons() {

        int weaponNumber = 1;

        System.out.println(Colors.UNDERLINED + "⚜ Weapons ⚜:" + Colors.RESET);

        for (Weapon weapon : weapons) {
            System.out.println(weaponNumber + ". " + weapon.getName());
            weaponNumber++;
        }
    }

    public String getWeaponsString() {

        StringBuilder sb = new StringBuilder();
        int weaponNumber = 1;

        sb.append("⚜ Weapons ⚜:" + "\n");

        for (Weapon weapon : weapons) {
            sb.append(weaponNumber + ". " + weapon.getName() + "\n");
            weaponNumber++;
        }
        return sb.toString();
    }



    public void showPotions() {

        int potionNumber = 1;

        System.out.println(Colors.UNDERLINED + "\uD81A\uDD0D Potions \uD81A\uDD0D:" + Colors.RESET);

        for (Potion potion : potions) {
            System.out.println(potionNumber + ". " + potion.getName() + Colors.RESET);
            System.out.print(Colors.RED + "Health +" + potion.getHealth() + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength +" + potion.getStrength() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility +" + potion.getAgility() + Colors.RESET + Colors.RESET);
            System.out.println(Colors.BLUE + " Intelligence +" + potion.getIntelligence() + Colors.RESET);
            potionNumber++;
        }
    }

    public String getPotionString() {

        StringBuilder sb = new StringBuilder();

        int potionNumber = 1;

        sb.append("\uD81A\uDD0D Potions \uD81A\uDD0D:\n");

        for (Potion potion : potions) {
            sb.append(potionNumber + ". " + potion.getName() + "\n");
            potionNumber++;
        }
        return sb.toString();
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

    public void removePotion(Potion potion) {
        potions.remove(potion);
    }

}
