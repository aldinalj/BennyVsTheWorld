package com.aldina.test;

import com.aldina.demo.Inventory;
import com.aldina.demo.shop.Potion;
import com.aldina.demo.shop.weapons.MagicStaff;
import com.aldina.demo.shop.weapons.WaterSword;
import com.aldina.demo.shop.weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    @Test
    public void testAddPotion() {
        Potion potion = new Potion("Health",5,0,0,0,0);
        inventory.addPotion(potion);
        List<Potion> potionsInventory = inventory.getPotions();

        assertEquals(potion.getName(), potionsInventory.get(0).getName());
    }

    @Test
    public void testRemovePotion() {
        Potion potion = new Potion("Health",5,0,0,0,0);
        inventory.addPotion(potion);
        List<Potion> potionsInventory = inventory.getPotions();

        inventory.removePotion(potion);

        assertEquals(0, potionsInventory.size());
    }

    @Test
    public void testGetPotions() {
        Potion potion = new Potion("Health",5,0,0,0,0);
        Potion potion2 = new Potion("Agility",0,0,2,0,0);

        inventory.addPotion(potion);
        inventory.addPotion(potion2);

        List<Potion> potionsInventory = inventory.getPotions();

        assertEquals("Health", potionsInventory.get(0).getName());
        assertEquals("Agility", potionsInventory.get(1).getName());
    }

    @Test
    public void testAddWeapon() {

        Weapon magicStaff = new MagicStaff("MS",1);
        inventory.addWeapon(magicStaff);
            List<Weapon> weaponsInventory = inventory.getWeapons();

        assertEquals("MS", weaponsInventory.get(0).getName());
    }

    @Test
    public void testGetWeapons() {
        Weapon magicStaff = new MagicStaff("MS",1);
        Weapon waterSword = new WaterSword("WS",1);

        inventory.addWeapon(magicStaff);
        inventory.addWeapon(waterSword);

        List<Weapon> weaponsInventory = inventory.getWeapons();

        assertEquals("MS", weaponsInventory.get(0).getName());
        assertEquals("WS", weaponsInventory.get(1).getName());
    }
}



