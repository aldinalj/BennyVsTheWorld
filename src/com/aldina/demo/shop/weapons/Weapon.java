package com.aldina.demo.shop.weapons;

import com.aldina.demo.characters.Weakness;
import com.aldina.demo.characters.Character;

import java.util.List;


public interface Weapon {

    String getName();
    int getPrice();
    int attack(Character attacker, Character target);
    List<Weakness> getSpecialties();
    Weapon copy();
}
