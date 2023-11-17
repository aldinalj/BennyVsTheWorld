package com.aldina.demo.text;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    private static InputHandler instance = null;

    public static InputHandler instance() {
        if(instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    private Scanner in;

    private InputHandler() {
        in = new Scanner(System.in);
    }

    public InputHandler changeStream(String in) {
        return changeStream(new ByteArrayInputStream(in.getBytes()));
    }

    public InputHandler changeStream(InputStream in) {
        this.in = new Scanner(in);
        return this;
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
