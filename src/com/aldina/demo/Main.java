package com.aldina.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("A young man named Benny must defeat his new girlfriend's seven evil exes one by one in order" +
                " to win her heart. Get ready to help Benny win over his beloved Frida so they can live happily ever after." +
                "\nWhat's your name player?");

        String playerName = sc.nextLine();
        Player player = new Player(playerName, 0, 13, 13, 13, 13, 0, 13);

        System.out.println("Welcome " + playerName + " before we begin the battles of Frida's heart, you should know a few things");
        // Insert lore

       do {
           System.out.println("1. Fight 2. Show status 3. Quit game");
           switch (sc.nextInt()) {
               case 1 -> {
                   if (player.fight()) {
                       // survived encounter
                   }
                   else {
                       // game over
                       // TODO: print game over message
                       System.exit(0);
                   }
               }
               case 2 -> player.showStatus();
               case 3 -> System.exit(0);
               default -> System.out.println("You chose a non-valid input. Please try again.");
           }
       } while (true);
    }
}
