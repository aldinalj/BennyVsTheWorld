package com.aldina.demo;

import com.aldina.demo.characters.Player;
import com.aldina.demo.shop.Potion;
import com.aldina.demo.shop.weapons.MemeCannon;
import com.aldina.demo.text.Colors;
import com.aldina.demo.text.InputHandler;

public class TempleOfKnowledge {

    private Player player;
    private InputHandler in;
    private int level;

    public TempleOfKnowledge(Player player) {
        this.player = player;
        in = InputHandler.instance();
        level = 0;
    }


    /* public void completeLevel(int level) {
        if (level >= 1 && level <= 30) {
            levelCompleted[level - 1] = true;
            if (level < 30) {
                levelUnlocked[level] = true;
            }
        }
    }


    public void enterLevel(int level) {
        if (level >= 1 && level <= 30) {
            if (levelUnlocked[level - 1] && !levelCompleted[level - 1]) {
                System.out.println("Level " + level);
                playLevel(level);
            } else {
                System.out.println("Complete the previous level to unlock this one.");
            }
        }
    } */


    public void playLevel() {

        while (true) {
            System.out.println("1. Go to level " + (level + 1) + "\n0. Go back");
            int choice = in.takeNumber();
            if (choice == 1) {
                switch (level) {
                    case 0 -> one();
                    case 1 -> two();
                    case 2 -> three();
                    case 3 -> four();
                    case 4 -> five();
                    case 5 -> six();
                    case 6 -> seven();
                    case 7 -> eight();
                    case 8 -> nine();
                    case 9 -> ten();
                    case 10 -> eleven();
                    case 11 -> twelve();
                    case 12 -> thirteen();
                    case 13 -> fourteen();
                    case 14 -> fifteen();
                    case 15 -> sixteen();
                    case 16 -> seventeen();
                    case 17 -> eighteen();
                    case 18 -> nineteen();
                    case 19 -> twenty();
                    case 20 -> twentyone();
                    case 21 -> twentytwo();
                    case 22 -> twentythree();
                    case 23 -> twentyfour();
                    case 24 -> twentyfive();
                    case 25 -> twentysix();
                    case 26 -> twentyseven();
                    case 27 -> twentyeight();
                    case 28 -> twentynine();
                    case 29 -> thirty();
                }
                level++;
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("⚠ Invalid choice. Please try again.");
            }
        }
    }

    private void one() {

        System.out.println("Which of the following is not a programming language?\n1) Java 2) SQL 3) JPEG");
        switch (in.takeString()) {
            case "1" -> {
                System.out.println("C'mon bro... you're just going to piss all over this game like that? You know what? I'm not going to let that slide.");
                in.takeString();
                System.exit(0);
            }
            case "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +5 gold");
                player.setGold(player.getGold() + 5);

                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void two() {

        System.out.println("What is the term for a named storage location that can hold a value or data?\n1) Function 2) Class 3) Variable");
        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +10 gold");
                player.setGold(player.getGold() + 10);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void three() {

        System.out.println("What construct allows you to repeat a set of instructions multiple times in a controlled manner?\n1) For loop 2) Switch case 3) If statement");
        switch (in.takeString()) {
            case "1", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +10 gold");
                player.setGold(player.getGold() + 10);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void four() {

        System.out.println("What is the process of creating an instance of a class called?\n1) Declaration 2) Instantiation 3) Inheritance");
        switch (in.takeString()) {
            case "1", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +15 gold");
                player.setGold(player.getGold() + 15);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void five() {

        System.out.println("What do you call a set of rules for writing code in a specific programming language?\n1) Syntax 2) Algorithm 3) Variable");
        switch (in.takeString()) {
            case "2", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +10 gold");
                player.setGold(player.getGold() + 10);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void six() {

        System.out.println("what is the term for a piece of code that can be called and executed with specific inputs?\n1) Class 2) Module 3) Function");
        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +15 gold");
                player.setGold(player.getGold() + 15);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void seven() {

        System.out.println("In web development, what language is used for adding style and formatting to web pages?\n1) HTML 2) CSS 3) Java");
        switch (in.takeString()) {
            case "2", "3" -> {
                System.out.println("✗ I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +5 gold");
                player.setGold(player.getGold() + 5);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void eight() {

        System.out.println("What is the Java operator used to create an instance of a class?\n1) this 2) new 3) super");
        switch (in.takeString()) {
            case "2", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +10 gold");
                player.setGold(player.getGold() + 10);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void nine() {

        System.out.println("What is the access modifier in Java that allows a variable or method to be accessed only within the same class?\n1) public 2) private 3) protected");
        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +15 gold");
                player.setGold(player.getGold() + 15);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void ten() {

        System.out.println("In Java, what is the term for a mechanism that allows a method to be defined in multiple forms in the same class or in different classes?\n1) Polymorphism 2) Overriding 3) Overloading");
        switch (in.takeString()) {
            case "2", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +15 gold");
                player.setGold(player.getGold() + 15);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }

        boolean running = true;
        do {
            System.out.println("You found a chest! On it says \"10 digits is required to open the chest. Remember that knowledge is key...\"\nCan't guess? " + Colors.PINKst + "\n0. Go back ⏎" + Colors.RESET + " Otherwise type in the 10 digits.");
            System.out.print(Colors.GREENin + "❁༺  " + Colors.RESET);
            switch (in.takeString()) {
                case "3322131131" -> {
                    System.out.println("WOW! You unlocked the chest! Here's your rewards:\n+400 gold + meme cannon");
                    player.setGold(player.getGold() + 400);
                    Potion healthPotion = new Potion("Health Potion", 50, 0, 0, 0, 0);
                    player.getInventory().addPotion(healthPotion);
                    MemeCannon memeCannon = new MemeCannon("MemeCannon");
                    player.getInventory().addWeapon(memeCannon);
                    running = false;
                }
                case "0" -> running = false;
                default -> System.out.println("Nope! Try again.");
            }
        } while (running);
    }


    private void eleven() {

        System.out.println("Which collection interface in Java is used to implement a dynamic array?\n1) List 2) Set 3) Map");
        switch (in.takeString()) {
            case "2", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twelve() {

        System.out.println("How is method overloading different from method overriding?");
        System.out.println("1) Method overloading allows a subclass to provide a specific implementation of a method, while method " +
                "overriding allows different classes to share the same method signature.");
        System.out.println("2) Method overloading occurs within the same class, while method overriding occurs in different classes.");
        System.out.println("3) Method overloading involves creating methods with the same name but different parameters " +
                "within the same class, while method overriding involves creating a new implementation of a method from a " +
                "superclass in a subclass.");

        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void thirteen() {

        System.out.println("How does polymorphism support flexibility in Java?");
        System.out.println("1) Polymorphism allows a method to perform different actions based on the object calling it.");
        System.out.println("2) Polymorphism prevents the creation of multiple objects of the same class.");
        System.out.println("3) Polymorphism restricts access to methods based on their access modifiers");
        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void fourteen() {

        System.out.println("How does the static keyword affect variables and methods?");
        System.out.println("It allows variables and methods to be accessed by other classes in the same package.");
        System.out.println("2) It indicates that variables and methods belong to the class itself, not to individual instances.");
        System.out.println("3) It restricts the access of variables and methods to within the same class only.");
        switch (in.takeString()) {
            case "3", "1" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void fifteen() {
        System.out.println("What is the difference between an abstract class and an interface in Java?");
        System.out.println("1) An abstract class can have both abstract and concrete methods, while an interface can only have abstract methods.");
        System.out.println("2) An abstract class cannot have constructors, whereas an interface can define constructors.");
        System.out.println("3) An abstract class can be instantiated directly, while an interface cannot be instantiated.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void sixteen() {

        System.out.println("What is the purpose of the finalize() method?");
        System.out.println("1) It is used to force garbage collection on an object.");
        System.out.println("2) It is called by the garbage collector before reclaiming an object's memory.");
        System.out.println("3) It is used to define the initial state of an object.");


        switch (in.takeString()) {
            case "3", "1" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void seventeen() {

        System.out.println("What are checked and unchecked exceptions?");
        System.out.println("1)  Checked exceptions are exceptions that need to be explicitly handled by the programmer using try-catch blocks, while unchecked exceptions do not require handling.");
        System.out.println("2) Checked exceptions are those that occur during compilation, while unchecked exceptions occur during runtime.");
        System.out.println("3) Checked exceptions are subclasses of RuntimeException, while unchecked exceptions are subclasses of Exception.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void eighteen() {

        System.out.println(" What's the significance of the super() method in Java.");
        System.out.println("1) The super() method is used to override methods in the superclass.");
        System.out.println("2) The super() method is used to access static methods of the superclass");
        System.out.println("3) The super() method is used to call the superclass's constructor explicitly from the subclass constructor.");


        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void nineteen() {

        System.out.println("What is the difference between String, StringBuffer, and StringBuilder in Java?");
        System.out.println("1) StringBuffer and StringBuilder both use an array of characters internally, while String uses a linked list.");
        System.out.println("2) String is immutable, StringBuffer is synchronized but less efficient, and StringBuilder is not synchronized but more efficient for single-threaded operations.");
        System.out.println("3) String and StringBuffer are both immutable, while StringBuilder is mutable.");


        switch (in.takeString()) {
            case "3", "1" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +20 gold");
                player.setGold(player.getGold() + 20);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twenty() {

        System.out.println("How does multithreading improve the performance of Java applications?");
        System.out.println("1) Multithreading enhances the security of Java applications by isolating critical tasks.");
        System.out.println("2) Multithreading enables Java programs to execute multiple tasks simultaneously, utilizing multiple CPU cores and improving overall performance.");
        System.out.println("3) Multithreading optimizes memory usage by reducing the size of objects in Java applications.");

        switch (in.takeString()) {
            case "1", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentyone() {

        System.out.println("What is the difference between ArrayList and LinkedList in Java, specifically in terms of performance and use cases?");
        System.out.println("1) ArrayList uses a resizable array for its internal implementation, providing better performance for frequent insertion and deletion operations. It is preferable for small-sized collections.");
        System.out.println("2) Both ArrayList and LinkedList have similar performance characteristics and are interchangeable based on personal preference.");
        System.out.println("3) LinkedList uses a doubly linked list internally, offering faster performance for random access but slower insertion and deletion compared to ArrayList. It's more suitable for large-sized collections requiring frequent add/remove operations.");


        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentytwo() {

        System.out.println("How does the synchronized keyword work in Java, and what role does it play in concurrent programming?");
        System.out.println("1) synchronized ensures that only one thread at a time can execute a particular block of code or method, preventing multiple threads from accessing it simultaneously. It maintains thread safety by providing mutual exclusion.");
        System.out.println("2) The synchronized keyword is used to prioritize certain threads over others, allowing them to execute critical sections of code first.");
        System.out.println("3) synchronized is used to forcibly terminate threads that exceed a specified time limit, preventing deadlocks in concurrent applications.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentythree() {

        System.out.println("Explain the difference between the compareTo() and equals() methods in Java.");
        System.out.println("1) The compareTo() method compares two objects based on their content, while the equals() method compares the memory addresses of the objects.");
        System.out.println("2) The compareTo() method is used for comparing objects in a specific order, while the equals() method checks for the equality of the objects' contents.");
        System.out.println("3) Both compareTo() and equals() methods are used for comparing objects based on their content, with no significant difference between them.");


        switch (in.takeString()) {
            case "3", "1" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +30 gold");
                player.setGold(player.getGold() + 30);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentyfour() {

        System.out.println("What's the role and significance of the volatile keyword in Java concerning multi-threaded environments.");
        System.out.println("1) volatile keyword is used to restrict access to a variable within the same thread, avoiding conflicts with other threads.");
        System.out.println("2) volatile keyword is used to ensure that a variable's value is visible to all threads, preventing thread interference and ensuring memory consistency.");
        System.out.println("3) volatile keyword is used to synchronize threads and ensure sequential execution of code blocks accessing the variable.");


        switch (in.takeString()) {
            case "3", "1" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentyfive() {

        System.out.println("Discuss the differences between the HashMap and ConcurrentHashMap classes concerning thread-safety and performance.");
        System.out.println("1) HashMap uses a synchronized approach for thread safety, while ConcurrentHashMap utilizes fine-grained locking mechanisms for improved concurrent access and scalability.");
        System.out.println("2) HashMap is thread-safe and designed for concurrent access, while ConcurrentHashMap is not thread-safe and requires explicit synchronization for concurrent access.");
        System.out.println("3) Both HashMap and ConcurrentHashMap provide the same level of thread-safety and performance characteristics.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +30 gold");
                player.setGold(player.getGold() + 30);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentysix() {

        System.out.println("Explain the concept of Generics and how they enhance type safety in collections and classes.");
        System.out.println("1) Generics allow classes and methods to operate on objects of various types, providing runtime type checking and ensuring type safety at compile-time.");
        System.out.println("2) Generics enable the creation of polymorphic methods and classes that can accept objects of any type, ensuring dynamic type resolution during runtime.");
        System.out.println("3) Generics allow the specification of types (e.g., <T>) in classes and methods to enforce type constraints, ensuring type safety and reducing the need for explicit type casting.");


        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentyseven() {

        System.out.println("Explain the concept of serialization and deserialization, emphasizing the use of the Serializable interface.");
        System.out.println("1) Serialization is the process of converting objects into a byte stream, while deserialization is the reverse process of reconstructing objects from the byte stream. The Serializable interface is used to indicate that an object's state can be serialized.");
        System.out.println("2) Serialization is the process of converting primitive data types into objects, while deserialization is the process of converting objects into primitive data types. The Serializable interface is used to implement custom serialization logic.");
        System.out.println("3) Serialization and deserialization are mechanisms used to compress and decompress data in Java applications, and the Serializable interface is used to enable compression of objects.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "1" -> {
                System.out.println("Correct! +30 gold");
                player.setGold(player.getGold() + 30);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentyeight() {

        System.out.println("What's the differences between the Stack and Queue interfaces in Java, their implementations, and their use cases.");
        System.out.println("1) Both Stack and Queue represent FIFO data structures, with Stack implemented using an array and Queue using a doubly linked list. They are interchangeable based on performance requirements.");
        System.out.println("2) Stack represents a FIFO data structure, while Queue represents a LIFO data structure. Stack is implemented using an array, while Queue uses a linked list.");
        System.out.println("3) Stack represents a Last-In-First-Out (LIFO) data structure, while Queue represents a First-In-First-Out (FIFO) data structure. Stack is implemented using a linked list, while Queue uses a dynamic array.");


        switch (in.takeString()) {
            case "1", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "3" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void twentynine() {

        System.out.println("Explain the concept of the ThreadLocal class in Java and its use in multi-threaded applications.");
        System.out.println("1) ThreadLocal is a class used to define global variables accessible across all threads in a Java application, ensuring shared state and synchronized access.");
        System.out.println("2) ThreadLocal allows each thread to have its own copy of a variable, providing thread isolation and avoiding data sharing issues in multi-threaded environments.");
        System.out.println("3) ThreadLocal is used to manage thread priority levels and scheduling in Java's multi-threaded applications, ensuring fair execution among threads.");


        switch (in.takeString()) {
            case "1", "3" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
                
            }
            case "2" -> {
                System.out.println("Correct! +25 gold");
                player.setGold(player.getGold() + 25);
                
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }


    private void thirty() {

        System.out.println("Explain the concept of the Java Memory Model (JMM) and its role in ensuring thread safety and visibility in multi-threaded environments.");
        System.out.println("1) The Java Memory Model (JMM) defines how Java threads interact through memory, specifying the behavior of variables' reads and writes in a multi-threaded environment. It ensures thread safety by providing rules for the ordering of memory operations and guarantees visibility of changes made by one thread to other threads.");
        System.out.println("2) JMM refers to the management of memory leaks in Java applications, ensuring efficient utilization of heap and stack memory among threads.");
        System.out.println("3) JMM primarily deals with optimizing memory allocation and garbage collection in multi-threaded applications, ensuring minimal memory overhead.");


        switch (in.takeString()) {
            case "3", "2" -> {
                System.out.println("I'm sorry but that's incorrect. No rewards for you.");
            }
            case "1" -> {
                System.out.println("Correct! +40 gold");
                player.setGold(player.getGold() + 40);
            }
            default -> System.out.println("⚠ Invalid choice. Please try again.");
        }
    }
}
