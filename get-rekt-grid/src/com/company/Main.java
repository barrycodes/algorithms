package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gridExercise();
    }

    private static void gridExercise() {
        boolean keepAlive = true;
        while (keepAlive) {
            try {
                System.out.println("ENTER WORD:");
                String input = new Scanner(System.in).nextLine();
                System.out.println("ENTER WIDTH:");
                int width = new Scanner(System.in).nextInt();
                System.out.println("ENTER HEIGHT:");
                int height = new Scanner(System.in).nextInt();
                doGridExercise(input, width, height);
            } catch (Exception ex) {
                keepAlive = false;
            }
        }
    }

    private static void setGridLetter(char[][] grid, int x, int y, char c) {
        grid[y][x] = c;
    }

    private static void writeWord(char[][] grid, String word, int x, int y, boolean horizontal, boolean forward) {
        StringBuilder wordBuilder = new StringBuilder(word);
        if (!forward)
            wordBuilder.reverse();
        for (char c : wordBuilder.toString().toCharArray()) {
            setGridLetter(grid, x, y, c);
            if (horizontal) ++x;
            else ++y;
        }
    }

    private static void writeAll(char[][] grid, String word, int width, int height) {
        boolean forward = (width % 2 == 1);
        writeHorizontals(grid, word, width, height, forward);
        writeVerticals(grid, word, width, height, forward);
    }

    private static void writeHorizontals(char[][] grid, String word, int width, int height, boolean forward) {
        for (int y = 0; y < grid.length; y += (word.length() - 1)) {
            boolean rowForward = forward;
            for (int x = 0; x < (grid[0].length - 1); x += (word.length() - 1)) {
                writeWord(grid, word, x, y, true, rowForward);
                rowForward = !rowForward;
            }
            forward = !forward;
        }
    }

    private static void writeVerticals(char[][] grid, String word, int width, int height, boolean forward) {
        for (int x = 0; x < grid[0].length; x += (word.length() - 1)) {
            boolean colForward = forward;
            for (int y = 0; y < (grid.length - 1); y += (word.length() - 1)) {
                writeWord(grid, word, x, y, false, colForward);
                colForward = !colForward;
            }
            forward = !forward;
        }
    }

    private static char[][] initializeGrid(char[][] grid) {
        for (char[] row : grid)
            for (int i = 0; i < row.length; ++i)
                row[i] = ' ';
        return grid;
    }

    private static void doGridExercise(String word, int width, int height) {
        char[][] grid = makeGrid(word, width, height);
        writeAll(grid, word, width, height);
        printGrid(grid);
    }

    private static char[][] makeGrid(String word, int width, int height) {
        return
                initializeGrid(
                        new char
                                [word.length() + (height-1) * (word.length() - 1)]
                                [word.length() + (width-1) * (word.length() - 1)]);
    }

    private static void printGrid(char[][] grid) {
        StringBuilder result = new StringBuilder();
        for (char[] row : grid) {
            for (char c : row)
                result.append(c + " ");
            result.append("\r\n");
        }
        System.out.println(result);
    }
}