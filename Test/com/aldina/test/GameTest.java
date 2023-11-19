package com.aldina.test;

import com.aldina.demo.Game;
import com.aldina.demo.characters.Player;
import com.aldina.demo.text.InputHandler;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void checkDeath() {
        Player player = new Player("Player",1,1,1,1,1,1,1,1);
        Game game = new Game(player);

        InputHandler.instance().changeStream("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1");

        boolean result = game.act();

        assertEquals(false, result);
    }

}
