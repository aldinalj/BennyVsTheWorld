package com.aldina.demo;

import com.aldina.demo.characters.Player;
import com.aldina.demo.weapons.MagicStaff;
import com.aldina.demo.weapons.ShockArrows;
import com.aldina.demo.weapons.Spear;
import com.aldina.demo.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private Inventory shopInventory;

    public Shop() {

        List<Potion> potionList = new ArrayList<>();
        potionList.add(new Potion("Health potion", 50, 0, 0, 0, 50));
        potionList.add(new Potion("Strength potion", 0, 2, 0, 0, 50));
        potionList.add(new Potion("Agility potion", 0, 0, 2, 0, 50));
        potionList.add(new Potion("Intelligence potion", 0, 0, 0, 2, 50));
        potionList.add(new Potion("SuperClass potion", 50, 2, 2, 2, 300));

        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(new ShockArrows("Shock Arrows", 60));
        weaponList.add(new Spear("Spear", 20));
        weaponList.add(new MagicStaff("Magic Staff", 80));

        this.shopInventory = new Inventory(potionList, weaponList);
    }

    public void browse(Player player) {

        System.out.println("Welcome to the shop. What would you like to do?");
        InputHandler in = new InputHandler();
        boolean running = true;

        do {
            System.out.println("1. ㈣ View inventory ㈣\n2. ⚜ Buy weapons ⚜ \n3. \uD81A\uDD0D Buy potions \uD81A\uDD0D \n4. Go back");
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);
            switch (in.takeString()) {
                case "1" -> {
                    System.out.println(Colors.YELLOW + "☆ Gold: " + player.getGold() + Colors.RESET);
                    player.getInventory().showInventory();
                }
                case "2" -> browseWeapons(player);
                case "3" -> browsePotions(player);
                case "4" -> running = false;
                default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ Did your fingers slip? ..." + Colors.RESET);
            }
        } while (running);

    }

    private void browseWeapons(Player player) {

        boolean running = true;
        InputHandler in = new InputHandler();

        do {

            System.out.print(Colors.YELLOW + "☆ Gold: " + player.getGold() + Colors.RESET);

            int weaponNumber = 1;
            for (Weapon weapon : shopInventory.getWeapons()) {
                System.out.println("\n" + weaponNumber + ". " + weapon.getName() + Colors.RESET);
                System.out.print(Colors.YELLOW + " Price: " + weapon.getPrice() + Colors.RESET);
                weaponNumber++;
            }

            System.out.println("\n" + weaponNumber + ". Go back");
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);

            int choice = in.takeNumber();

            if (choice >= 1 && choice < weaponNumber) {
                Weapon selectedWeapon = shopInventory.getWeapons().get(choice - 1);
                buyWeapon(player, selectedWeapon);
            } else if (choice == weaponNumber) {
                running = false;
            } else {
                System.out.println(Colors.BOLD + Colors.RED + "⚠ Did your fingers slip?..." + Colors.RESET);
            }
        } while (running);


    }


    private void buyWeapon(Player player, Weapon weapon) {

        InputHandler in = new InputHandler();
        boolean running = true;

        do {
            System.out.println("1. Buy " + weapon.getName() + "\n2. Go back");
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);
            switch (in.takeString()) {
                case "1" -> {
                    if (player.getGold() >= weapon.getPrice()) {
                        player.setGold(player.getGold() - weapon.getPrice());
                        player.getInventory().addWeapon(weapon.copy());
                        System.out.println(weapon.getName() + " added to your inventory.");
                        running = false;
                    } else {
                        System.out.println("（⊙_⊙）  -  'You're too poor for this...'");
                    }
                }
                case "2" -> running = false;
                default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ Well that's not an option..." + Colors.RESET);
            }

        } while (running);
    }

    private void browsePotions(Player player) {

        boolean running = true;
        InputHandler in = new InputHandler();

        do {

            System.out.print(Colors.YELLOW + "☆ Gold: " + player.getGold() + Colors.RESET);

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
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);


            int choice = in.takeNumber();

            if (choice >= 1 && choice < potionNumber) {
                Potion selectedPotion = shopInventory.getPotions().get(choice - 1);
                buyPotion(player, selectedPotion);
            } else if (choice == potionNumber) {
                running = false;
            } else {
                System.out.println(Colors.BOLD + Colors.RED + "⚠ Did your fingers slip?..." + Colors.RESET);
            }
        } while (running);

    }

    private void buyPotion(Player player, Potion potion) {
        InputHandler in = new InputHandler();
        boolean running = true;

        do {
            System.out.println("1. Buy " + potion.getName() + "\n2. Go back ☜");
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);

            switch (in.takeString()) {
                case "1" -> {
                    if (player.getGold() >= potion.getPrice()) {
                        player.setGold(player.getGold() - potion.getPrice());
                        player.getInventory().appPotion(potion.copy());
                        System.out.println(Colors.ITALICS + Colors.WHITE + potion.getName() + " added to your inventory." + Colors.RESET);
                        running = false;
                    } else {
                        System.out.println("（⊙_⊙）  -  'You're too poor for this...'");
                    }
                }
                case "2" -> running = false;
                default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ Well that's not an option..." + Colors.RESET);
            }

        } while (running);
    }
}

