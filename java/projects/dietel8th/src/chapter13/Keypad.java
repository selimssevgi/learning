package chapter13;

import java.util.Scanner;

/**
 * Created by ssselim on 8/5/16.
 */
public class Keypad {
    private Scanner input;

    public Keypad() {
        this.input = new Scanner(System.in);
    }

    public int getInput() {
        return input.nextInt();
    }
}
