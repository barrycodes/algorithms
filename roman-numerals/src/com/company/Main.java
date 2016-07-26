package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        romanExercise();
    }

    private static void romanExercise() {
        int num = 0;
        while (num >= 0) {
            Scanner s = new Scanner(System.in);
            num = s.nextInt();
            System.out.println(convertToRoman(num));
        }
    }

    private static String convertToRoman(int num) {

        Integer[] allNums = new Integer[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String[] allStrings = new String[] {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        String result = "";

        while (num > 0) {
            for (int i = 0; i < allNums.length; ++i) {
                Integer k = allNums[i];
                if (num >= k) {
                    String s = allStrings[i];
                    if (s.length() < 2) {
                        int m = num / k;
                        for (int j = 0; j < m; ++j)
                            result += s;
                        num -= m * k;
                    }
                    else {
                        result += s;
                        num -= k;
                    }
                }
            }
        }
        return result;
    }
}
