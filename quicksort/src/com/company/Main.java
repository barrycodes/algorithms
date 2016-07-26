package com.company;

public class Main {

    public static void main(String[] args) {
        sortExercise();
    }

    private static void sortExercise() {
        doSortExercise(20);
    }

    private static int[] getRandomNumbers(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; ++i)
            result[i] = (int)(Math.random() * 100D);
        return result;
    }

    private static String assembleNumbers(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            sb.append(" " + nums[i]);
        }
        return sb.toString();
    }

    private static int doPartition(int[] nums, int leftIndex, int rightIndex) {
        int pivot = nums[(leftIndex + rightIndex) / 2];
        while (leftIndex <= rightIndex) {
            while (nums[leftIndex] < pivot) ++leftIndex;
            while (nums[rightIndex] > pivot) --rightIndex;
            if (leftIndex <= rightIndex) {
                int t = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = t;
                ++leftIndex;
                --rightIndex;
            }
        }
        return leftIndex;
    }

    private static void quickSort(int[] nums, int leftIndex, int rightIndex) {
        int index = doPartition(nums, leftIndex, rightIndex);
        if (leftIndex < index - 1)
            quickSort(nums, leftIndex, index - 1);
        if (index < rightIndex)
            quickSort(nums, index, rightIndex);
    }

    private static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void doSortExercise(int count) {
        int[] nums = getRandomNumbers(count);
        System.out.println("QUICK SORT");
        System.out.println("Initial sequence:");
        System.out.println(assembleNumbers(nums));

        sort(nums);

        System.out.println("Sorted sequence:");
        System.out.println(assembleNumbers(nums));
    }
}
