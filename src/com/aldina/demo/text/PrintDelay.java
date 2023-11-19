package com.aldina.demo.text;

public class PrintDelay {

    public static void printDelay(String str) {
        for (char c : str.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}