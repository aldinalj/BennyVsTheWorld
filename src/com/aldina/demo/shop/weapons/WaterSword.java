package com.aldina.demo.shop.weapons;

import com.aldina.demo.Weakness;
import com.aldina.demo.text.Colors;
import com.aldina.demo.characters.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterSword implements Weapon {

    private String name;
    private int price;
    private List<Weakness> specialities = new ArrayList<>();

    public WaterSword(String name, int price) {
        this.name = name;
        this.price = price;
        specialities.add(Weakness.WATER);
        specialities.add(Weakness.DARK);
    }

    public void displayInfo() {
        System.out.println("Weapon: " + getName());
        System.out.println("Price: " + getPrice());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int attack(Character attacker, Character target) {
        System.out.println("Water Sword swooshed!");
        int damage = attacker.getBaseDamage() + attacker.getStrength();

        for(Weakness speciality : specialities) {
            if(target.getWeakness() == speciality) {
                damage *= 2;
                System.out.println(target.getName() + "'s weakness was exploited!");
            }
        }

        if (new Random().nextInt(100) < attacker.getIntelligence()) {
            damage *= 2;
            System.out.println(Colors.RED_BACKGROUND + Colors.UNDERLINED + "! CRITICAL HIT !" + Colors.RESET);
        }

        if (new Random().nextInt(100) < target.getAgility()) {
            System.out.println(Colors.BLUE + Colors.ITALICS + "Oh... " + target.getName() + " dodged " + attacker.getName() + "'s attack!\n" + Colors.RESET);
            damage = 0;
        } else {
            System.out.println(Colors.RED + attacker.getName() + " caused " + damage + " damage!\n" + Colors.RESET);
        }

        return damage;
    }

    @Override
    public List<Weakness> getSpecialties() {
        return specialities;
    }


    @Override
    public Weapon copy() {
        return new WaterSword(name, price);
    }
}





