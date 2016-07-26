package com.company;

import java.util.Scanner;

public class Main {

    static String word = "abcde";

    static char[][] forwardGrid= createForwardGrid(word);
    static char[][] backwardGrid= createBackwardGrid(word);

    public static void main(String[] args) {

        char[][] grid = populateGrid(word,4,3);

        printGrid(grid);
    }

    public static char[][] createForwardGrid(String word){
        char[][] grid= new char[word.length()][word.length()];

        //populate top line forwards
        populateWordForwards(word, grid[0]);

        //Fill in middle section by populating it with the middle letters. The left is filled in forwards and the right is filled in
        //backwards
        for(int heightIndex=1; heightIndex<word.length()-1;++heightIndex){
            grid[heightIndex][0]=word.charAt(heightIndex);
            grid[heightIndex][word.length()-1]=word.charAt(word.length()-1-heightIndex);
        }

        //populate bottom line backwards
        populateWordBackwards(word, grid[word.length()-1]);

        return grid;
    }

    public static char[][] createBackwardGrid(String word){
        char[][] grid= new char[word.length()][word.length()];

        //populate top line backwards
        populateWordBackwards(word, grid[0]);

        //Fill in middle section by populating it with the middle letters. The left is filled in backwards and the right is filled in
        //forwards
        for(int heightIndex=1; heightIndex<word.length()-1;++heightIndex){
            grid[heightIndex][0]=word.charAt(word.length()-1-heightIndex);
            grid[heightIndex][word.length()-1]=word.charAt(heightIndex);
        }

        //populate bottom line forwards
        populateWordForwards(word, grid[word.length()-1]);

        return grid;
    }

    public static char[][] populateGrid(String word, int widthRepetitions, int heightRepetitions) {
        int widthLength = findArrayLength(word, widthRepetitions);
        int heightLength = findArrayLength(word, heightRepetitions);

        char[][] grid = new char[heightLength][widthLength];

        //If the width repetitions is even, we start by printing the word backwards
        boolean heightIsBackwards = widthRepetitions % 2 == 0;

        for (int heightIndex = 0; heightIndex < heightRepetitions; ++heightIndex) {
            boolean widthIsBackwards = heightIsBackwards;
            for (int widthIndex = 0; widthIndex < widthRepetitions; ++widthIndex) {
                if (widthIsBackwards) {
                    populateGridBackwards(grid, heightIndex, widthIndex);
                } else {
                    populateGridForwards(grid, heightIndex, widthIndex);
                }

                widthIsBackwards=!widthIsBackwards;
            }
            heightIsBackwards = !heightIsBackwards;
        }
        return grid;
    }

    public static void populateGridForwards(char[][] grid, int heightIndex, int widthIndex){
        heightIndex*=(word.length()-1);
        widthIndex*=(word.length()-1);

        for(int curHeight=0;curHeight<word.length();++curHeight){
            for(int curWidth=0; curWidth<word.length();++curWidth){
                grid[curHeight+heightIndex][curWidth+widthIndex]=forwardGrid[curHeight][curWidth];
            }
        }
    }

    public static void populateGridBackwards(char[][] grid, int heightIndex, int widthIndex){
        heightIndex*=(word.length()-1);
        widthIndex*=(word.length()-1);

        for(int curHeight=0;curHeight<word.length();++curHeight){
            for(int curWidth=0; curWidth<word.length();++curWidth){
                grid[curHeight+heightIndex][curWidth+widthIndex]=backwardGrid[curHeight][curWidth];
            }
        }
    }

    public static int findArrayLength(String word, int repetitions) {
        return word.length() + (repetitions - 1) * (word.length() - 1);
    }

    public static void populateWordBackwards(String word, char[] gridRow) {
        for(int index=0;index<word.length();++index){
            gridRow[index]=word.charAt(word.length()-1-index);
        }
    }

    public static void populateWordForwards(String word, char[] gridRow) {
        for(int index=0;index<word.length();++index){
            gridRow[index]=word.charAt(index);
        }
    }

    public static void printGrid(char[][] grid) {
        for (int height = 0; height < grid.length; ++height) {
            for (int width = 0; width < grid[height].length; ++width) {
                System.out.print(grid[height][width] + " ");
            }
            System.out.println();
        }
    }
}