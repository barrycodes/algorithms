package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gcdExercise();
    }

    private static void gcdExercise() {
        int a = getInput();
        int b = getInput();
        System.out.println("RESULT: ");
        System.out.println(getGreatestCommonDenominator(a, b));
    }

    private static int getInput() {
        int input = -1;
        while (input < 0) {
            System.out.println("ENTER AN INTEGER:");
            try {
                input = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("INVALID!");
            }
        }
        return input;
    }

    private static int getGreatestCommonDenominator(int a, int b) {
        int result = -1;
        int remainder;

        int smallest = Math.min(a, b);
        int biggest = Math.max(a, b);

        // test for boundary cases
        if (smallest == 0)
            result = biggest;
        else {
            // start with remainder of greatest divided by smallest
            remainder = biggest % smallest;
            // recursive call
            result = getGreatestCommonDenominator(smallest, remainder);
        }
        return result;
    }
}