package com.aldina.demo;

import com.aldina.demo.weapons.MagicStaff;
import com.aldina.demo.weapons.ShockArrows;
import com.aldina.demo.weapons.Spear;
import com.aldina.demo.weapons.Weapon;
import com.aldina.demo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    public void shop(int gold, List<Weapon> weapons, List<Item> items) {

        System.out.println("Welcome to the shop. What would you like to do?");
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Current balance \n2. Buy weapons \n3. Buy potions \n4. View inventory \n5. Go back");
            switch (sc.nextLine()) {
                case "1" -> System.out.println("Gold: " + gold);
                case "2" -> browseWeapons(gold, weapons);
                case "3" -> browsePotions(gold, items);
                //case "4" -> viewInventory();
                case "5" -> running = false;
                default -> System.out.println("Did your fingers slip? ...");
            }
        } while (running);

    }

    public void browseWeapons(int gold, List<Weapon> weapons) {
        List<Weapon> weaponList = new ArrayList<>();

        weaponList.add(new ShockArrows("Shock Arrows", 30, 10, 5, 15, 60));
        weaponList.add(new Spear("Spear", 20, 2, 10, 2, 20));
        weaponList.add(new MagicStaff("Magic Staff", 40, 2, 2, 2, 80));

        int weaponNumber = 1;
        for (Weapon weapon : weaponList) {
            System.out.println(weaponNumber + ". " + weapon.getName() + Colors.RESET);
            System.out.println(Colors.PINK + "Damage: " + weapon.getDamage() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility: " + weapon.getAgility() + Colors.RESET + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength: " + weapon.getStrength() + Colors.RESET);
            System.out.print(Colors.BLUE + " Intelligence: " + weapon.getIntelligence() + Colors.RESET);
            System.out.print(Colors.YELLOW + " Price: " + weapon.getPrice() + Colors.RESET);
            weaponNumber++;
        }

        System.out.println("4. Go back");

        boolean running = true;
        Scanner sc = new Scanner(System.in);

        do {
            int choice = Integer.parseInt(sc.nextLine());

            if (choice >= 1 && choice < weaponNumber) {
                Weapon selectedWeapon = weaponList.get(choice - 1);
                buyWeapon(selectedWeapon, gold, weapons);
            } else if (choice == weaponNumber) {
                running = false;
            } else {
                System.out.println("Did your fingers slip?...");
            }
        } while (running);


    }


    public void buyWeapon(Weapon weapon, int gold, List<Weapon> weapons) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Buy " + weapon.getName() + "\n 2. Go back");
            switch (sc.nextLine()) {
                case "1" -> {
                    if (gold >= weapon.getPrice()) {
                        gold = -weapon.getPrice();
                        weapons.add(weapon);
                        System.out.println(weapon + " added to your inventory.");
                    } else {
                        System.out.println("（⊙_⊙）  -  'You're too poor for this...'");
                    }
                }
                case "2" -> running = false;
                default -> System.out.println("Well that's not an option...");
            }

        } while (running);
    }

    public void browsePotions(int gold, List<Item> items) {

        List<Item> itemsList = new ArrayList<>();

        int itemNumber = 1;

        for (Item item : itemsList) {
            System.out.println(itemNumber + ". " + item.getName() + Colors.RESET);
            System.out.print(Colors.RED + "Health +" + item.getHealth() + Colors.RESET);
            System.out.print(Colors.PURPLE + " Strength +" + item.getStrength() + Colors.RESET);
            System.out.print(Colors.GREEN + " Agility +" + item.getAgility() + Colors.RESET + Colors.RESET);
            System.out.print(Colors.BLUE + " Intelligence +" + item.getIntelligence() + Colors.RESET);
            System.out.print(Colors.YELLOW + " Price: " + item.getPrice() + Colors.RESET);
            itemNumber++;

            System.out.println("4. Go back");

            boolean running = true;
            Scanner sc = new Scanner(System.in);

            do {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice >= 1 && choice < itemNumber) {
                    Item selectedItem = itemsList.get(choice - 1);
                    buyItem(selectedItem, gold, itemsList);
                } else if (choice == itemNumber) {
                    running = false;
                } else {
                    System.out.println("Did your fingers slip?...");
                }
            } while (running);

        }
    }

    public void buyItem(Item item, int gold, List<Item> items) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Buy " + item.getName() + "\n 2. Go back");
            switch (sc.nextLine()) {
                case "1" -> {
                    if (gold >= item.getPrice()) {
                        gold =- item.getPrice();
                        items.add(item);
                        System.out.println(item + " added to your inventory.");
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

