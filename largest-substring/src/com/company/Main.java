package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// find the largest substring of input without repeating a character
public class Main {

    private static boolean keepAlive = true;

    public static void main(String[] args) {
        largestSubstringExercise();
    }

    private static void largestSubstringExercise() {
        while (keepAlive)
            printResult(getLargestSubstring(getInput()));
    }

    private static void printResult(String result) {
        System.out.println("RESULT:");
        System.out.println(result);
    }

    private static String getLargestSubstring(String input) {
        String result = "";
        List<String> candidateStrings = new ArrayList<String>();
        for (int i = 0; i < input.length(); ++i)
            candidateStrings.add(getSubstringNoRepeat(input, i));
        result = getLargestString(candidateStrings);
        return result;
    }

    private static String getLargestString(List<String> allStrings) {
        String result = "";
        for (String s : allStrings)
            if (s.length() > result.length())
                result = s;
        return result;
    }

    private static String getSubstringNoRepeat(String input, int startIndex) {
        String result = "" + input.charAt(startIndex);
        char[] chars = input.toCharArray();
        for (int i = startIndex + 1; i < input.length(); ++i) {
            char c = chars[i];
            if (!result.contains("" + c))
                result += c;
            else
                break;
        }
        return result;
    }

    private static String getInput() {
        String result = "";
        while (result.length() < 1 && keepAlive) {
            System.out.println("ENTER SOME TEXT (Q TO QUIT):");
            result = new Scanner(System.in).nextLine();
            if (result.length() < 1)
                System.out.println("INVALID");
            else if (result.equals("Q"))
                keepAlive = false;
        }
        return result;
    }
}