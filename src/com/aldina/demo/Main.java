package com.aldina.demo;

import com.aldina.demo.characters.LoreMaster;
import com.aldina.demo.characters.Player;
import com.aldina.demo.shop.Shop;
import com.aldina.demo.text.Colors;
import com.aldina.demo.text.InputHandler;
import static com.aldina.demo.text.PrintDelay.printDelay;

public class Main {
    public static void main(String[] args) {

        InputHandler in = InputHandler.instance();

        System.out.println(Colors.PINK_BACKGROUND + "≪ °❈° ≫ BENNY VS THE WORLDⒸ ≪ °❈° ≫ " + Colors.RESET + "\n(A story based on Scott Pilgrim VS The World, different video games and JAVA23)");

        printDelay(Colors.PINKst + "Benny, a 22-year-old magician, leads an ordinary life, filling his free hours immersed in DnD adventures. However, his routine takes an unexpected" +
                " turn when Frida, a stunning young woman with both beauty and strategic prowess in DnD, enters his world. Enthralled by her, Benny swiftly falls for her charms. In return, " +
                "Frida finds Benny captivating, especially when he showcases his magical talent, transforming stones into an array of vibrant hues. As their connection deepens, Benny musters " +
                "the courage to ask Frida out, only to be met with an unexpected challenge: \"In order to date me, you have to defeat my seven evil exes in combat.\"" +
                "These exes comprise a diverse cast of eccentric and formidable characters, each possessing unique abilities and personalities. Now, Benny requires assistance to conquer Frida's " +
                "exes and win the chance to be with his beloved Frida.\nNow, before we delve into this tale, could you kindly share your name, dear player?" + Colors.RESET);
        System.out.print(Colors.GREENin + "➺ " + Colors.RESET);

        String playerName = in.takeString();
        Player player = new Player(playerName, 1, 13, 13, 13, 120, 0, 2, 50);
        Game game = new Game(player);
        LoreMaster loreMaster = new LoreMaster();
        Shop shopInstance = new Shop();
        TempleOfKnowledge temple = new TempleOfKnowledge(player);

        printDelay("\nWelcome " + Colors.GREENin + playerName + Colors.RESET + ".\nBefore we begin the battles of Frida's heart, you should know a few things. \nWhen this pops up "
                + Colors.GREENin + "❁༺" + Colors.RESET + " you have to make to make a choice. \nYou will fight Frida's exs in a randomized order.\nFor every 100xp you'll level up and everytime you level up you'll gain +2 in agility, strength & intelligence. \nThere is a " +
                "temple of knowledge where you can get gold if you answer the questions right. \nAs a wise Swedish man once said " +
                "\"Fuskare förlorar privilegiet att skryta\", which roughly translates to \n\"Cheaters loses the privilege to brag\", so make sure you actually only use the knowledge you" +
                " know to answer the questions. \nThere's a shop filled with weapons and potions. Talk to the lore master for hints to the best weapons to use in battle. \nHere! Take these 50 gold" +
                " coins that you can use in the shop.\nDon't forget to fix soft-wrap in the console for a non-horrendous reading experience.\nGood Luck!\n");

        do {

            System.out.println("1. ⚔ Meet Frida's ex ⚔ \n2. ↕ Show status ↕\n3. ♔ Talk to lore master ♔\n4. ⾕ Visit shop ⾕\n5. ꕥ Temple Of Knowledge ꕥ" + Colors.PINKst + "\n0. Quit game" + Colors.RESET);
            System.out.print(Colors.GREENin + "❁༺  " + Colors.RESET);
            switch (in.takeNumber()) {
                case 1 -> {
                    if (!game.act()) {
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

                        game.writeGameInfoToFile();
                        System.exit(0);
                    }
                }
                case 2 -> player.showStatus();
                case 3 -> loreMaster.loreMaster();
                case 4 -> shopInstance.browse(player);
                case 5 -> temple.playLevel();
                case 0 -> {
                    printDelay("Wow, quitting already? I mean, who needs progress in a game, right? You're like a master strategist, " +
                            "in your own unique way. It's a bit pathetic, but hey, quitting is the new winning, I guess. Go ahead, make that grand exit!");
                    System.exit(0);
                }
                default ->
                        System.out.println(Colors.BOLD + Colors.RED + "⚠ You chose a non-valid input. Please try again." + Colors.RESET);
            }
        } while (true);
    }
}
