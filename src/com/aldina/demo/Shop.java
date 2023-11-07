package com.aldina.demo;

import com.aldina.demo.characters.Player;
import com.aldina.demo.weapons.MagicStaff;
import com.aldina.demo.weapons.ShockArrows;
import com.aldina.demo.weapons.Spear;
import com.aldina.demo.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    private Inventory shopInventory;

    public Shop() {

        List<Potion> potionList = new ArrayList<>();
        potionList.add(new Potion("Health potion", 50, 0, 0, 0, 50));
        potionList.add(new Potion("Strength potion", 0, 2, 0, 0, 50));
        potionList.add(new Potion("Agility potion", 0, 0, 2, 0, 50));
        potionList.add(new Potion("Intelligence potion", 0, 0, 0, 2, 50));
        potionList.add(new Potion("SuperClass potion", 50, 2, 2, 2, 50));

        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(new ShockArrows("Shock Arrows", 30, 10, 5, 15, 60));
        weaponList.add(new Spear("Spear", 20, 2, 10, 2, 20));
        weaponList.add(new MagicStaff("Magic Staff", 40, 2, 2, 2, 80));


        this.shopInventory = new Inventory(potionList, weaponList);
    }

    public void browse(Player player) {

        System.out.println("Welcome to the shop. What would you like to do?");
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Current balance \n2. Buy weapons \n3. Buy potions \n4. View inventory \n5. Go back");
            switch (sc.nextLine()) {
                case "1" -> System.out.println("Gold: " + player.getGold());
                case "2" -> browseWeapons(player);
                case "3" -> browsePotions(player);
                case "4" -> player.getInventory().showInventory();
                case "5" -> running = false;
                default -> System.out.println("Did your fingers slip? ...");
            }
        } while (running);

    }

    private void browseWeapons(Player player) {

        boolean running = true;
        InputHandler in = new InputHandler();

        do {
            int weaponNumber = 1;
            for (Weapon weapon : shopInventory.getWeapons()) {
                System.out.println("\n" + weaponNumber + ". " + weapon.getName() + Colors.RESET);
                System.out.print(Colors.PINK + "Damage: " + weapon.getDamage() + Colors.RESET);
                System.out.print(Colors.GREEN + " Agility: " + weapon.getAgility() + Colors.RESET + Colors.RESET);
                System.out.print(Colors.PURPLE + " Strength: " + weapon.getStrength() + Colors.RESET);
                System.out.print(Colors.BLUE + " Intelligence: " + weapon.getIntelligence() + Colors.RESET);
                System.out.print(Colors.YELLOW + " Price: " + weapon.getPrice() + Colors.RESET);
                weaponNumber++;
            }

            System.out.println("\n" + weaponNumber + ". Go back");

            int choice = in.takeNumber();

            if (choice >= 1 && choice < weaponNumber) {
                Weapon selectedWeapon = shopInventory.getWeapons().get(choice - 1);
                buyWeapon(player, selectedWeapon);
            } else if (choice == weaponNumber) {
                running = false;
            } else {
                System.out.println("Did your fingers slip?...");
            }
        } while (running);


    }


    private void buyWeapon(Player player, Weapon weapon) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Buy " + weapon.getName() + "\n2. Go back");
            switch (sc.nextLine()) {
                case "1" -> {
                    if (player.getGold() >= weapon.getPrice()) {
                        player.setGold(player.getGold() - weapon.getPrice());
                        player.getInventory().addWeapon(weapon.copy());
                        System.out.println(weapon.getName() + " added to your inventory.");
                    } else {
                        System.out.println("（⊙_⊙）  -  'You're too poor for this...'");
                    }
                }
                case "2" -> running = false;
                default -> System.out.println("Well that's not an option...");
            }

        } while (running);
    }

    private void browsePotions(Player player) {

        boolean running = true;
        InputHandler in = new InputHandler();

        do {

            int potionNumber = 1;

            for (Potion potion : shopInventory.getPotions()) {
                System.out.println("\n" + potionNumber + ". " + potion.getName() + Colors.RESET);
                System.out.print(Colors.RED + "Health +" + potion.getHealth() + Colors.RESET);
                System.out.print(Colors.PURPLE + " Strength +" + potion.getStrength() + Colors.RESET);
                System.out.print(Colors.GREEN + " Agility +" + potion.getAgility() + Colors.RESET + Colors.RESET);
                System.out.print(Colors.BLUE + " Intelligence +" + potion.getIntelligence() + Colors.RESET);
                System.out.print(Colors.YELLOW + " Price: " + potion.getPrice() + Colors.RESET);
                potionNumber++;
            }

            System.out.println("\n" + potionNumber + ". Go back");


            int choice = in.takeNumber();

            if (choice >= 1 && choice < potionNumber) {
                Potion selectedPotion = shopInventory.getPotions().get(choice - 1);
                buyPotion(player, selectedPotion);
            } else if (choice == potionNumber) {
                running = false;
            } else {
                System.out.println("Did your fingers slip?...");
            }
        } while (running);

    }

    private void buyPotion(Player player, Potion potion) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Buy " + potion.getName() + "\n2. Go back");
            switch (sc.nextLine()) {
                case "1" -> {
                    if (player.getGold() >= potion.getPrice()) {
                        player.setGold(player.getGold() - potion.getPrice());
                        player.getInventory().appPotion(potion.copy());
                        System.out.println(potion.getName() + " added to your inventory.");
                    } else {
                        System.out.println("（⊙_⊙）  -  'You're too poor for this...'");
                    }
                }
                case "2" -> running = false;
                default -> System.out.println("Well that's not an option...");
            }

        } while (running);
    }
}

