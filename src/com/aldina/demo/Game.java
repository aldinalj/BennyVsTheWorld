package com.aldina.demo;

import java.util.List;
import java.util.Random;

import com.aldina.demo.characters.Monster;
import com.aldina.demo.characters.Player;
import com.aldina.demo.weapons.Fists;
import com.aldina.demo.weapons.Weapon;

public class Game {

    private Player player;
    private List<Monster> monsters;
    private Shop shopInstance = new Shop();

    public Game(Player player) {
        this.player = player;
        monsters = Monster.generateMonsters();
    }


    public boolean act() {
        Monster monster = getMonster();
        monster.showStatus();
        InputHandler in = new InputHandler();


        while (true) {
            System.out.println("What would you like to do?\n1. Attack \n2. Equip weapon \n3. Use potion(s) \n4. Get status\n5. Flee \n6. Visit shop");
            System.out.print(Colors.GREENin + "❁༺ " + Colors.RESET);

            switch (in.takeNumber()) {
                case 1 -> {
                    player.attack(monster);
                    monster.attack(player);
                }
                case 2 -> player.equipWeapon();
                case 3 -> player.usePotion();

                case 4 -> {
                    player.showStatus();
                    monster.showStatus();
                }
                case 5 -> {
                    if (player.flee()) {
                        monster.restoreHealth();
                        return true;
                    }
                    else {
                        monster.attack(player);
                    }
                }
                case 6 -> shopInstance.browse(player);
                default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ Invalid input. Please try again." + Colors.RESET);
            }
            if (player.getCurrentHealth() <= 0) return false;
            if (monster.getCurrentHealth() <= 0) {
                if (monster.getName().equals("Krille")) {
                    winGame();
                    quit();
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
            return new Monster("Krille",2,2,2,100,2,2,500, new Fists("Strong fists", 0));
        }

    }

    private void winGame(){

        System.out.println("\"Thank you so much " + player.getName() + ". I finally won Frida's heart!");
        InputHandler in = new InputHandler();
        in.takeString();
    }



}

