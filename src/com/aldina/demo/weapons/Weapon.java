package com.aldina.demo.weapons;

import com.aldina.demo.characters.Character;

public interface Weapon {

    String getName();
    int getPrice();
    int attack(Character attacker, Character target);
    Weapon copy();
}
