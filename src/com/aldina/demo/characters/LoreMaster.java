package com.aldina.demo.characters;

import com.aldina.demo.text.Colors;
import com.aldina.demo.text.InputHandler;
import com.aldina.demo.text.PrintDelay;

public class LoreMaster {

    public void loreMaster() {

        PrintDelay.printDelay(Colors.ITALICS + "Ah, welcome, brave traveler, to the realm where tales whisper and legends echo. Gather 'round, for within these hallowed lands, secrets are whispered by the winds, and knowledge resides within the stones themselves. Should you seek enlightenment or yearn for the forgotten tales of yore, I, the Lore Master, shall illuminate your path with the wisdom of ages past." +  Colors.RESET);

        boolean running = true;

        do {
            System.out.println(Colors.ITALICS + "What would you like to know?" + Colors.RESET + "\n1. The history of Frida's love-life\n2. How to defeat the exs " + Colors.PINKst + "\n0. Go back ⏎" + Colors.RESET);

            InputHandler in = InputHandler.instance();

            switch(in.takeString()) {
                case "1" -> fridasHistory();
                case "2" -> defeatEx();
                case "0" -> {
                    System.out.println(Colors.PINKst + "0. Go back ⏎" + Colors.RESET);
                    running = false;
                }
                default -> System.out.println("⚠ Uh-oh! Looks like you've stumbled into the land of non-magic. No dragons, no secret passages—just this screen and a slightly disappointed wizard. You're hunting for bugs? Well, sorry to disappoint, but this place is as bug-free as a tidy picnic. How about trying a legit input next time? I promise, the adventure's way more thrilling on the other side!");
            }

        } while (running);
    }

    private void fridasHistory() {
        PrintDelay.printDelay("\"Ah, a connoisseur of refined tastes, I see. Naturally, you're privy to the intricate tapestry of Frida's romantic escapades! Settle in, for this tale is one to behold.\"");
        System.out.println("""
                \"Anton was Frida's first boyfriend, and their relationship began during a pivotal time in both of their lives. Anton had just relocated from Umeå to Stockholm, embarking on a new chapter in his life as he entered the second grade in a completely unfamiliar school. The change had left him feeling extremely nervous, surrounded by the novelty of a new city, school, and the faces of strangers.
                On that nerve-wracking first day of school, Anton's life took a significant turn when he encountered Frida. She approached him with a warm and welcoming demeanor, introducing herself and helping him navigate the intricate web of his new classmates. Their initial interaction quickly evolved into a deep and enduring friendship. As they journeyed through their school years, their bond strengthened, and by the time they reached fifth grade, their relationship blossomed into a sweet romance.
                However, their love story faced an unexpected obstacle. Anton's parents secured new job opportunities in Norway, forcing the couple to navigate the challenges of a long-distance relationship. Despite their best efforts, the strain proved too much, and they eventually parted ways. Nevertheless, the memory of their first love remained etched in their hearts, leaving a lasting impact on both of their lives.
                ***
                Sidon marked the beginning of Frida's second chapter in the world of relationships. She met Sidon while snorkeling, a chance encounter that led to a unique connection. His profound knowledge and passion for the ocean were captivating. Despite being a stranger, Sidon's extroverted nature led him to share the best snorkeling spots with Frida. She playfully dubbed him a "sea creature" due to his expertise in navigating the aquatic world.
                Their relationship was marked by a series of exciting adventures and fun activities. Frida was drawn to Sidon's optimistic outlook on life, and she appreciated his zest for living in the moment. However, as time passed, she started to find his unwavering optimism overwhelming and considered him too naive and unserious. Their differing life plans eventually led to their breakup.
                ***
                Nabooru became the next significant chapter in Frida's romantic journey. They crossed paths in college, introduced by mutual friends. What drew Frida to Nabooru was her fiery and ambitious nature. The intensity of their love grew rapidly as they spent a great deal of time together, creating cherished memories.
                Nabooru, however, harbored aspirations that extended beyond staying in one place. She was committed to humanitarian work that often took her to distant places. Frida, in her unwavering support for Nabooru's dreams, faced the challenges of a relationship tested by geographical separation. Eventually, Nabooru reached a difficult decision. The demands of her humanitarian work made it impossible to maintain the relationship, and she chose to end it. The breakup left Frida deeply devastated and struggling to find her way forward.
                Following her breakup with Nabooru, Frida found herself in a dark and tumultuous emotional state. Her subsequent relationships took her on a different path, beginning with Pudge, a chance encounter in a butcher shop. This period in her life is one that she looks back on with mixed emotions, and she prefers not to dwell on it.
                ***
                Herobrine entered Frida's life in a club during her birthday celebration. His striking appearance and background as a construction worker intrigued her. Initially, their relationship appeared promising. However, as time passed, Frida started to feel increasingly uncomfortable due to Herobrine's strange behavior, which bordered on stalking. The breakup provided her with relief when he eventually moved away.
                ***
                Frida's sixth ex, Browser, was known for his sense of humor. He had the remarkable ability to make her laugh and enjoy life's lighter side. However, Browser had a darker, toxic side marked by anger issues that Frida found difficult to handle. Their breakup, though bittersweet, eventually led Frida to her seventh and final ex.
                ***
                Krille was a pivotal figure in Frida's love life. They crossed paths in Gothenburg while attending the same school, and Frida was deeply impressed by his programming skills. She became his source of encouragement and motivation to pursue his dreams, particularly a career as a teacher.
                Frida wholeheartedly believed in Krille's talents and aspirations, urging him to share them with others. While Frida discovered her dream job in Gothenburg, Krille found the perfect opportunity, albeit one that would be in a different city, Liljeholmen, Stockholm. This significant geographical distance posed a challenge for their relationship. Krille, ultimately, decided that a long-distance relationship wasn't suitable for his new adventure in Stockholm. The decision was heartbreaking for Frida, leaving her with deep feelings of loss. Yet, Krille, too, missed her in his own way.\"
                                
                """);
    }

    private void defeatEx() {
        PrintDelay.printDelay("Each monster has its Achilles' heel. Anton, a fighting type, succumbs to flying weapons. Sidon, the -almost- water creature, falters against electric weaponry. Nabooru, a magic wielder, is vulnerable to dark forces. Pudge, also a fighter, is bested by fairy weapons. Herobrine's dark type is no shocker; his foil remains a mystery for you to decipher. " +
                "Bowser mirrors his fiery temperament—what douses flames? Now, for the mightiest adversary, Krille. Despite his penchant for memes, sometimes our fondest loves become our vulnerabilities. Legend speaks of a weapon hidden in the temple of knowledge, its nature uncertain. Wouldn't it be wise to seek it out?");
    }

}
