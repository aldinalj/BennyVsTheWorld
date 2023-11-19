package com.aldina.test;

import com.aldina.demo.characters.Player;
import com.aldina.demo.shop.Potion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player("Benny", 1, 1, 1, 1, 1, 0, 1, 1);
    }

    @Test
    public void testLevelUp() {
        int initialLevel = player.getLevel();
        int xpToEarn = 150;

        player.addXp(xpToEarn);
        player.levelUp(0);

        int leftoverXp = 50;
        int expectedLevel = initialLevel + 1;


        assertEquals(expectedLevel, player.getLevel());
        assertEquals(leftoverXp, player.getXp());
    }
}



