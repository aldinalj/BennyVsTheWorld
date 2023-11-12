package com.aldina.demo.text;

import java.util.Scanner;

public class InputHandler {
    private Scanner in;

    public InputHandler() {
        in = new Scanner(System.in);
    }

    public int takeNumber() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (Exception ignored) {}
        }
    }

    public boolean hasNumber() {
        return in.hasNextInt();
    }

    public String takeString() {
        return in.nextLine();
    }

    public void clear() {
        in = new Scanner(System.in);
    }

}
