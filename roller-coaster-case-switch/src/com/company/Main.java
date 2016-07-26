package com.company;

public class Main {

    public static void main(String[] args) {
        caseSwitchExercise();
    }

    private static void caseSwitchExercise() {
        String s = "To be, or not to be: that is the question.\r\n"
                + "Whether 'tis nobler in the mind to suffer.\r\n"
                + "The slings and arrows of outrageous fortune.\r\n"
                + "Or to take arms against a sea of troubles.\r\n"
                + "And by opposing end them, to die: to sleep.";

        System.out.print(doCaseSwitch(s));
    }

    private static String doCaseSwitch(String str) {

        StringBuilder sb = new StringBuilder();

        String[] lines = str.split("\r\n");

        for (String line : lines) {
            int cIndex = 0;
            for (char c : line.toCharArray()) {
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    sb.append(
                            ((cIndex % 2 == 0)
                                    ? Character.toUpperCase(c)
                                    : Character.toLowerCase(c)));
                    ++cIndex;
                }
                else sb.append(c);
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}