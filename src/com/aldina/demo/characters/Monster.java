package com.aldina.demo.characters;

import com.aldina.demo.Weakness;
import com.aldina.demo.shop.weapons.Fists;
import com.aldina.demo.shop.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {

    private String lore;
    public Monster(String name, int strength, int intelligence, int agility, int totalHealth, int baseDamage, int xp, int gold, Weapon equippedWeapon, String lore, Weakness weakness) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.totalHealth = totalHealth;
        this.currentHealth = totalHealth;
        this.baseDamage = baseDamage;
        this.xp = xp;
        this.gold = gold;
        this.equippedWeapon = equippedWeapon;
        this.lore = lore;
        this.weakness = weakness;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println();
    }

    public static List<Monster> generateMonsters() {

        String antonLore = """
                Anton was Frida's first boyfriend, and their relationship began during a pivotal time in both of their lives. Anton had just relocated from Umeå to Gothenburg, embarking on
                a new chapter in his life as he entered the second grade in a completely unfamiliar school. The change had left him feeling extremely nervous, surrounded by the novelty of a
                new city, school, and the faces of strangers. On that nerve-wracking first day of school, Anton's life took a significant turn when he encountered Frida. She approached him
                with a warm and welcoming demeanor, introducing herself and helping him navigate the intricate web of his new classmates. Their initial interaction quickly evolved into a deep
                and enduring friendship. As they journeyed through their school years, their bond strengthened, and by the time they reached fifth grade, their relationship blossomed into a sweet romance.
                However, their love story faced an unexpected obstacle. Anton's parents secured new job opportunities in Norway, forcing the couple to navigate the challenges of a long-distance relationship.
                Despite their best efforts, the strain proved too much, and they eventually parted ways. Nevertheless, the memory of their first love remained etched in their hearts, leaving a lasting impact
                on both of their lives.
                                
                """;

        String sidonLore = """
                Sidon marked the beginning of Frida's second chapter in the world of relationships. She met Sidon while snorkeling, a chance encounter that led to a unique connection.
                His profound knowledge and passion for the ocean were captivating. Despite being a stranger, Sidon's extroverted nature led him to share the best snorkeling spots with Frida.
                She playfully dubbed him a "sea creature" due to his expertise in navigating the aquatic world. Their relationship was marked by a series of exciting adventures and fun activities.
                Frida was drawn to Sidon's optimistic outlook on life, and she appreciated his zest for living in the moment. However, as time passed, she started to find his unwavering optimism
                overwhelming and considered him too naive and unserious. Their differing life plans eventually led to their breakup.
                                
                """;

        String nabooruLore = """
                Nabooru became the next significant chapter in Frida's romantic journey. They crossed paths in college, introduced by mutual friends.
                What drew Frida to Nabooru was her fiery and ambitious nature. The intensity of their love grew rapidly as they spent a great deal of time together, creating cherished memories.
                Nabooru, however, harbored aspirations that extended beyond staying in one place. She was committed to humanitarian work that often took her to distant places. Frida, in her unwavering
                support for Nabooru's dreams, faced the challenges of a relationship tested by geographical separation. Eventually, Nabooru reached a difficult decision. The demands of her humanitarian
                work made it impossible to maintain the relationship, and she chose to end it. The breakup left Frida deeply devastated and struggling to find her way forward.
                """;

        String pudgeLore = """
                Following her breakup with Nabooru, Frida found herself in a dark and tumultuous emotional state. Her subsequent relationships took her on a different path,
                beginning with Pudge, a chance encounter in a butcher shop. This period in her life is one that she looks back on with mixed emotions, and she prefers not to dwell on it.
                """;

        String herobrineLore = """
                Herobrine entered Frida's life in a club during her birthday celebration. His striking appearance and background as a construction worker intrigued her. Initially, their relationship
                appeared promising. However, as time passed, Frida started to feel increasingly uncomfortable due to Herobrine's strange behavior, which bordered on stalking. The breakup provided her
                with relief when he eventually moved away.
                """;

        String bowserLore = """
                Frida's sixth ex, Browser, was known for his sense of humor. He had the remarkable ability to make her laugh and enjoy life's lighter side. However, Browser had a darker, toxic side
                marked by anger issues that Frida found difficult to handle. Their breakup, though bittersweet, eventually led Frida to her seventh and final ex. 
                """;

        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster("Anton", 13, 13, 13, 50,2, 50, 50, new Fists("Fists",0), antonLore, Weakness.FLYING));
        monsterList.add(new Monster("Sidon", 13, 13, 13, 50,2, 50, 50, new Fists("Fists",0), sidonLore, Weakness.ELECTRIC));
        monsterList.add(new Monster("Nabooru", 13, 13, 13, 50,2, 50, 50, new Fists("Fists",0), nabooruLore, Weakness.DARK));
        monsterList.add(new Monster("Pudge", 13, 13, 13, 50, 2,50, 50, new Fists("Fists",0), pudgeLore, Weakness.FAIRY));
        monsterList.add(new Monster("Herobrine", 13, 13, 13, 50, 2,50, 50, new Fists("Fists",0), herobrineLore, Weakness.LIGHT));
        monsterList.add(new Monster("Bowser", 13, 13, 13, 50, 2,50, 50, new Fists("Fists",0), bowserLore, Weakness.WATER));

        return monsterList;
    }

    public String getLore() {
        return lore;
    }
}

