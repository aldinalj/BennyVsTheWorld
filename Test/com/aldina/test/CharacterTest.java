package com.aldina.test;

import com.aldina.demo.characters.Weakness;
import com.aldina.demo.characters.Character;
import com.aldina.demo.characters.Monster;
import com.aldina.demo.characters.Player;
import com.aldina.demo.shop.weapons.Fists;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharacterTest {

    @Test
    public void testAttack(){
        Character player = new Player("Player",1,10,0,0,1,1,1,1);
        Character monster = new Monster("Monster",1,1,1,100,1,1,1,new Fists("Fists",1),"", Weakness.MEMES);

        player.attack(monster);

        int damageTaken = 100 - monster.getCurrentHealth();

        assertEquals(11, damageTaken);
    }
}
