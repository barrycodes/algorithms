package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TwoNewBloods();
    }

    public static void TwoNewBloods() {

        int sum = 0;

        System.out.println("Enter a Whole Number homie...or else:");

        Scanner scanner = new Scanner(System.in);

        int input = -1;
        while (input < 0) {
            String cheese = scanner.nextLine();
            try {
                input = (Integer.parseInt(cheese));
            } catch (NumberFormatException ex) { }
        }
        String inputString = Integer.toString(input);

        for (int i = 0; i < inputString.length(); ++i)
            sum += Integer.parseInt("" + inputString.charAt(i));

        System.out.println(sum);
    }
}