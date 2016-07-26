package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        lexicographicPermutationsExercise();
    }

    private static void lexicographicPermutationsExercise() {
        Integer[] nums = {0,1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.addAll(Arrays.asList(nums));
        getNthPermutation(al, 1000000);
    }

    private static void moveNum(List<Integer> nums, int index1, int index2) {
        int temp = nums.get(index1);
        nums.remove(index1);
        nums.add(index2, temp);
    }

    private static String getStringFromList(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (Integer n : nums)
            sb.append(n);
        return sb.toString();
    }

    private static void storePermutation(TreeSet<String> results, List<Integer> permutation) {
        try {
            results.add(getStringFromList(permutation));
        } catch (Exception e) { }
    }

    private static String getNthPermutation(List<Integer> nums, int n) {
        String result = null;
        TreeSet<String> results = new TreeSet<String>();
        findNextPermutation(results, nums, 0);
        int i = 1;
        for (String s : results) {
            if (i++ == n) {
                System.out.println(s);
                break;
            }
        }
        return result;
    }

    private static void findNextPermutation(TreeSet<String> results, List<Integer> nums, int startIndex) {
        for (int i = startIndex; i < nums.size() - 1; ++i)
            for (int j = 0; j < nums.size() - i; ++j) {
                findNextPermutation(results, new ArrayList<Integer>(nums), i + 1);
                storePermutation(results, nums);
                moveNum(nums, i, nums.size() - 1);
            }
    }
}