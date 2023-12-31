package com.aldina.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.aldina.demo.characters.Monster;
import com.aldina.demo.characters.Player;
import com.aldina.demo.characters.Weakness;
import com.aldina.demo.text.Colors;
import com.aldina.demo.text.InputHandler;
import com.aldina.demo.shop.weapons.Fists;

import static com.aldina.demo.text.PrintDelay.printDelay;

public class Game {

    private int enemiesDefeated;
    private Player player;
    private List<Monster> monsters;

    public Game(Player player) {
        this.player = player;
        monsters = Monster.generateMonsters();
        enemiesDefeated = 0;
    }


    public boolean act() {
        Monster monster = getMonster();
        printDelay(monster.getLore());
        monster.showStatus();
        InputHandler in = InputHandler.instance();


        while (true) {
            System.out.println("What would you like to do?\n1. ⚔ Attack ⚔\n2. ⚜ Equip weapon ⚜\n3. \uD81A\uDD0D Consume potion \uD81A\uDD0D \n4. ↕ Get status ↕\n5. ꩜ Flee ꩜");
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
                default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ Invalid input. Please try again." + Colors.RESET);
            }
            if (player.getCurrentHealth() <= 0) return false;
            if (monster.getCurrentHealth() <= 0) {
                monsters.remove(monster);
                break;
            }
        }

        System.out.println("GOOD JOB! You slayed " +  monster.getName() + ".");
        player.addXp(monster.getXp());
        player.levelUp(monster.getGold());
        enemiesDefeated++;

        if (monster.getName().equals("Krille")) {
            winGame();
            quit();
        }

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
            String krilleLore = """
                Krille was a pivotal figure in Frida's love life. They crossed paths in Gothenburg while attending the same school, and Frida was deeply impressed by his programming skills. She became
                his source of encouragement and motivation to pursue his dreams, particularly a career as a teacher. Frida wholeheartedly believed in Krille's talents and aspirations, urging him to share
                them with others. While Frida discovered her dream job in Gothenburg, Krille found the perfect opportunity, albeit one that would be in a different city, Liljeholmen, Stockholm.
                This significant geographical distance posed a challenge for their relationship. Krille, ultimately, decided that a long-distance relationship wasn't suitable for his new adventure in Stockholm.
                The decision was heartbreaking for Frida, leaving her with deep feelings of loss. Yet, Krille, too, missed her in his own way.
                """;
            return new Monster("Krille",25,18,18,190,8,2,0, new Fists("Strong fists", 0), krilleLore, Weakness.MEMES);
        }

    }

    public void writeGameInfoToFile() {
        try {

            String filePath = "game_info.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            writer.write(player.getName() + "'s stats:");
            writer.write("\nEnemies defeated: " + enemiesDefeated);
            writer.write("\nLevel: " + player.getLevel());
            writer.write("\nInventory:\n");
            writer.write(player.getInventory().getWeaponsString());
            writer.write(player.getInventory().getPotionString());

            writer.close();

            System.out.println("Game info has been written to " + filePath);
        } catch (IOException e) {

        }
    }

    private void winGame(){

        printDelay("After the intense battles against Frida's seven exes, Benny and Frida found themselves standing amidst the debris, catching their breaths in the aftermath of the chaos. The air was thick with a mix of relief and something deeper—an unspoken understanding of the strength they'd discovered in each other throughout their journey.\n" +
                "Frida looked at Benny with a mix of emotions swirling in her eyes—gratitude, respect, and a newfound admiration that had blossomed through the trials they faced together. There was a moment of quiet between them, each understanding the significance of their shared experiences.\n" +
                "With a faint smile, Benny broke the silence. \"Frida, this journey has been something else. I've learned a lot about myself, about us,\" he confessed, his tone reflective yet filled with warmth.\n" +
                "Frida nodded, her gaze meeting his. \"Benny, you've shown me what it means to stand by someone, to fight for what you believe in,\" she replied softly.\n" +
                "Their eyes met, and in that fleeting moment, they both understood the depth of their connection. \n" +
                "Hand in hand, they walked away from the battlegrounds, leaving behind the remnants of their trials. As they stepped into the evening, a sense of peace settled between them—a shared understanding that their journey wasn't just about the battles fought, but about the unspoken connection they now carried in their hearts.\n" +
                "With each step forward, Benny and Frida embarked on a new chapter—a story of resilience, mutual understanding, and a bond that had withstood the ultimate test. They walked into the night, their intertwined destinies shining brightly against the canvas of a starry sky, carrying with them the lessons learned and the strength gained from their remarkable journey together.\n");

        System.out.println("""
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████▓▓░░░░▓▓▓▓████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▓▓▓▓████████▓▓░░░░░░▓▓▓▓██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████▒▒▒▒▒▒████▓▓████████████████░░░░░░▓▓▓▓██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████▒▒██████▒▒▒▒▒▒▒▒▒▒██▓▓░░██░░░░▓▓▓▓██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▓▓░░░░▓▓▓▓████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████████████▓▓██▒▒▒▒▒▒▒▒▒▒██▓▓░░░░▓▓▓▓▓▓████████▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒██▓▓██░░▓▓▓▓▓▓██▓▓▓▓██▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▓▓▓▓▓▓██▓▓▓▓██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░░░████▓▓▓▓▓▓██▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░▓▓▓▓▓▓▓▓██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▓▓██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████████████▒▒████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒▒▒██████████▒▒████████▒▒██████░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒██▒▒▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████  ░░░░██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒██▒▒██████▒▒▒▒▒▒▒▒▒▒██▒▒████          ░░░░██████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒██▒▒████▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒██  ██    ██    ░░░░▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████▒▒▒▒██▒▒██▒▒▒▒▒▒▒▒████████▒▒▒▒██  ██████      ░░░░▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██                ░░██▒▒▒▒▒▒██▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██        ░░░░    ░░██▒▒▒▒▒▒████▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▓▓              ▓▓▒▒▒▒▒▒██▒▒▒▒████████▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██          ░░▒▒████████▓▓▓▓████▒▒▒▒▓▓████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒██▒▒██████▓▓▓▓▓▓▓▓▓▓██▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓████████▒▒████████  ▓▓████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓██▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓██░░░░▓▓████████▓▓░░░░░░████▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒
                ▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒██▓▓████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▓▓██████▒▒████▒▒▒▒▒▒░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░░▒▒▓▓▒▒▒▒▒▒▒▒▒▒
                ▒▒██▒▒▒▒▒▒▒▒▒▒██  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒████▒▒▒▒████▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▓▓░░░░████████░░████████████████████      ██████▒▒▒▒  ░░██▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒██▒▒▒▒▒▒▒▒██  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒██████████▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░▓▓▒▒██████████░░████████████████████████░░██████▒▒  ░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒██▒▒▒▒▒▒██  ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░██████████████░░░░██████░░░░░░░░░░░░░░░░░░██████    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒██▒▒▒▒▒▒██  ██▒▒▒▒▒▒▒▒▒▒▒▒██████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████░░██████████░░░░░░░░██▒▒██████░░░░░░░░░░░░██░░██    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒██▒▒▒▒▒▒▒▒██  ██▒▒▒▒████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▓▓░░██████▒▒░░░░░░░░██▒▒▒▒▒▒▒▒████████▓▓░░██░░██    ░░████▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒████████████▓▓██████▒▒▒▒██████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▓▓░░░░██▓▓░░░░░░░░▒▒██▒▒▒▒▒▒██████▓▓▓▓▓▓██▓▓██▓▓▓▓██████▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▓▓▓▓░░▒▒▓▓▓▓▓▓▓▓██████████████▓▓▓▓▓▓██▓▓██▓▓░░░░░░██▓▓██▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒████████▒▒▒▒▒▒████████▒▒▒▒▒▒▒▒▒▒██████░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓██▓▓██▓▓██▓▓  ░░░░  ░░██░░██▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████░░░░▒▒██▒▒▒▒████████████▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒██░░░░░░░░██▒▒▒▒▒▒▒▒▒▒████████████████████████████▓▓██▓▓██░░░░    ░░░░██░░██▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████░░░░░░▒▒▒▒████▒▒▒▒▒▒▒▒▒▒████████▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒██░░░░░░░░░░░░██▒▒▒▒▒▒▒▒▒▒██████░░░░▒▒██▓▓▓▓████████▓▓██▓▓██░░░░    ░░░░██░░██▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░██████████▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░░░░░░░    ░░░░██▒▒▒▒▒▒▒▒▒▒██████░░▓▓    ██▒▒▒▒████████▓▓██░░  ░░░░  ░░██░░██▒▒▒▒▒▒▒▒
                ██████▒▒▒▒▒▒████▒▒▒▒░░░░░░░░░░░░▒▒▒▒░░░░░░░░░░████▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░░░░░░░    ░░░░██▒▒▒▒▒▒▒▒▒▒████████    ██    ░░░░░░▒▒██████▓▓░░░░░░░░░░██▓▓██▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒░░░░▒▒▒▒▒▒▒▒░░░░████░░░░░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░██▒▒▒▒▒▒▒▒▒▒▒▒██      ██            ░░░░▒▒████▓▓▓▓▓▓▓▓████▓▓██▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒██████████░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░░░░░    ░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▓▓▓▓██                ░░░░████████▓▓▒▒▒▒██████▒▒▒▒▒▒
                ▒▒░░░░░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░░░░░    ░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████████░░                ░░████▓▓▒▒░░░░░░████▓▓██▒▒▒▒
                ░░░░░░░░░░░░░░░░▒▒░░▒▒▒▒▓▓▓▓██▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░    ░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░░░██░░              ░░██░░▓▓░░      ▒▒██  ▓▓██▒▒
                ░░░░░░░░░░░░░░░░▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒░░░░░░░░░░░░  ▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓░░▒▒▓▓░░              ██  ░░        ░░▒▒██░░██▒▒
                ░░░░░░░░░░▒▒██████▒▒▒▒▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒░░░░░░░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░▒▒████░░          ██  ░░            ██  ░░██
                ▒▒░░▒▒████████▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒░░░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██████░░░░  ██    ░░            ██  ░░██
                ▒▒▒▒██████░░██▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████░░░░░░██████    ░░              ██  ░░██
                ████▒▒▒▒██░░  ██████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▓▓░░░░░░██████████▓▓░░░░    ██  ░░██
                ░░██▒▒▒▒██░░    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████░░░░▒▒▒▒██▓▓██████  ██  ░░██
                ██▒▒▒▒▒▒██░░    ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████░░██▒▒██████████▒▒
                ▒▒▒▒▒▒▒▒▒▒██▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██    ░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                    
                """);
        printDelay("\"Thank you so much " + player.getName() + ". I finally won Frida's heart!\"");
        writeGameInfoToFile();
        InputHandler in = InputHandler.instance();
        in.takeString();
    }



}

