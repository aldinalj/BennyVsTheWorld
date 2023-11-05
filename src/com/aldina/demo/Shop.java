package com.aldina.demo;

import java.util.Scanner;

public class Shop {

    public void shop(int gold) {

        System.out.println("Welcome to the shop. What would you like to do?");
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("1. Current balance 2. Buy weapons 3. Buy potions 4. View inventory");
            switch (sc.nextLine()) {
                case "1" -> System.out.println("Gold: " + gold);
                case "2" -> displayWeapons();
                case "3" -> displayPotions();
                case "4" -> running = false;
                default -> System.out.println("Did your fingers slip? ...");
            }
        } while (running);

    }

    public void displayWeapons() {}
    public void displayPotions() {}

}
