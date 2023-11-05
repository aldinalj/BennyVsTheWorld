package com.aldina.demo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player;
    private List<Monster> monsters;

    public Game(Player player) {
        this.player = player;
        monsters = Monster.generateMonsters();
    }

    public boolean act() {
        Monster monster = getMonster();
        monster.showStatus();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("What would you like to do?\n1. Attack \n2. Use potions \n3. Get status\n4. Flee");

            switch (sc.nextInt()) {
                case 1 -> {
                    player.attack(monster);
                    monster.attack(player);
                }
                //case -> 2

                case 3 -> {
                    player.showStatus();
                    monster.showStatus();
                }
                case 4 -> {
                    if (player.flee()) {
                        monster.restoreHealth();
                        return true;
                    }
                    else {
                        monster.attack(player);
                    }
                }
                //case 4 -> Shop.shop(player.getGold());
                default -> System.out.println("Invalid input. Please try again.");
            }
            if (player.getCurrentHealth() <= 0) return false;
            if (monster.getCurrentHealth() <= 0) {
                if (monster.getName().equals("Krille")) {
                    winGame();
                    System.exit(0);
                }
                monsters.remove(monster);
                break;
            }
        }

        System.out.println("GOOD JOB! You slayed " +  monster.getName() + ".");
        player.addXp(monster.getXp());
        player.levelUp(monster.getGold());
        return true;
    }


    public void quit() {
        System.exit(0);
    }

    private Monster getMonster() {

        if (monsters.size() != 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(monsters.size());
            Monster randomMonster = monsters.get(randomIndex);
            return randomMonster;
        } else {
            return new Monster("Krille",2,2,2,100,2,2,500);
        }

    }

    private void winGame(){

        System.out.println("\"Thank you so much " + player.getName() + ". I finally won Frida's heart!");
        Scanner sc = new Scanner(System.in);






        sc.nextLine();
    }


}

