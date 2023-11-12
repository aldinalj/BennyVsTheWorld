package com.aldina.demo;

import com.aldina.demo.characters.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();

        System.out.println(Colors.PINK_BACKGROUND + "≪ °❈° ≫ BENNY VS THE WORLD ≪ °❈° ≫ " + Colors.RESET + "\n(A story based on Scott Pilgrim VS The World, different video games and JAVA23)");

        System.out.println(Colors.PINKst + "Follow the story of Benny, a young man who's determined to win the heart of his new girlfriend, Frida." +
                "\nThe catch? He must confront her seven formidable ex-boyfriends, one by one." +
                "\nPrepare to aid Benny in his romantic adventure and help him secure his happily ever after with Frida.\n" +
                "Now, before we delve into this tale, could you kindly share your name, dear player?" + Colors.RESET);
        System.out.print(Colors.GREENin + "➺ " + Colors.RESET);

        String playerName = in.takeString();
        Player player = new Player(playerName, 1, 13, 13, 13, 500, 0, 2,4323);
        Game game = new Game(player);

        System.out.println("Welcome " + Colors.GREENin + playerName + Colors.RESET + ". Before we begin the battles of Frida's heart, you should know a few things. When this pops up "
                + Colors.GREENin + "❁༺" + Colors.RESET + " you have to make to make a choice. You will fight Frida's exs in a randomized order. I highly recommend you speak with the " +
                "lore master to best know hot to defeat them. There is a temple of knowledge where you can achieve awards if you answer the questions right. As a wise Swedish man once said " +
                "\"Fuskare förlorar privilegiet att skryta\", which roughly translates to \"Cheaters loses the privilege to brag\", so make sure you actually only use the knowledge you" +
                "know to answer the questions. There's a shop filled with weapons and potions. Talk to the lore master for hints to the best weapons to use in battle. Here's 50 gold coins" +
                " that you can use in tbe shop. Good luck!");

       do {
           if (player.getCurrentHealth() <= 0) {
               System.out.println("          " + Colors.RED_BACKGROUND + "☠  GAME OVER  ☠" + Colors.RESET);
               System.out.println(Colors.RED + """
                       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡶⠛⠛⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠋⠀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⢀⣠⠴⠞⠛⠉⠉⠉⠉⠉⠉⠛⠒⠾⢤⣀⠀⣀⣠⣤⣄⡀⠀⠀⠀
                       ⠀⠀⠀⣠⡶⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢭⡀⠀⠈⣷⠀⠀⠀
                       ⠀⠀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⢀⡟⠀⠀⠀
                       ⠀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⡅⠀⠀⠀
                       ⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣄⣀⠀
                       ⣾⠀⠀⣠⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣄⠀⠀⠀⠀⠀⠀⠸⡇⠉⣷
                       ⣿⠀⠰⣿⣿⣿⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⣧⡴⠋
                       ⣿⠀⠀⢸⠛⢫⠀⠀⢠⠴⠒⠲⡄⠀⠀⠀⠀⡝⠛⢡⠀⠀⠀⠀⠀⠀⢰⡏⠀⠀
                       ⢸⡄⠀⢸⡀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢸⠀⠀⠀⠀⠀⠀⡼⣄⠀⠀
                       ⠀⢳⡄⠀⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀⢸⠀⠀⠀⠀⢀⡼⠁⢸⡇⠀
                       ⠀⠀⠙⢦⣷⡈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠈⡇⠀⣀⡴⠟⠒⠚⠋⠀⠀
                       ⠀⠀⠀⠀⠈⠛⠾⢤⣤⣀⣀⡀⠀⠀⠀⠀⣀⣈⣇⡤⣷⠚⠉⠀⠀⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⠀⣰⠇⠀⠩⣉⠉⠉⠉⣩⠍⠁⠀⢷⣟⠀⠀⠀⠀⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⠀⡟⠐⠦⠤⠼⠂⠀⠸⠥⠤⠔⠂⠘⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⣸⣧⡟⠳⠒⡄⠀⠀⠀⡔⠲⠚⣧⣀⣿⠿⠷⣶⡆⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⠻⣄⢀⠀⠀⡗⠀⠀⠀⡇⠄⢠⠀⣼⠟⠀⢀⣨⠇⠀⠀⠀⠀⠀
                       ⠀⠀⠀⠀⠀⠀⠀⠙⢶⠬⠴⢧⣤⣤⣤⣽⣬⡥⠞⠛⠛⠋⠉⠀⠀
                       YOU RUINED BENNY'S CHANCE TO BE WITH FRIDA⠀⠀⠀⠀⠀
                       """ + Colors.RESET);
               System.exit(0);
           }

           System.out.println("1. Meet Frida's ex \n2. Show status \n3. Talk to lore master \n4. Quit game");
           System.out.print(Colors.GREENin + "❁༺  " + Colors.RESET);
           switch (in.takeNumber()) {
               case 1 -> game.act();
               case 2 -> player.showStatus();
               //case 3 -> loreMaster();
               case 4 -> System.exit(0);
               default -> System.out.println(Colors.BOLD + Colors.RED + "⚠ You chose a non-valid input. Please try again." + Colors.RESET);
           }
       } while (true);
    }
}
