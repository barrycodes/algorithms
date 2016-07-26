package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(days(new int[] { 4,3,0,9,9 }, 4));
    }

    public static int days(int[] arrivals, int numPerDay) {
        int result = 0;
        int backlogCount = 0;
        for (int i = 0; i < arrivals.length; ++i) {
            int newWidgetCount = arrivals[i];
            backlogCount += newWidgetCount;
            if (backlogCount > 0) {
                ++result;
                backlogCount -= numPerDay;
                if (backlogCount < 0)
                    backlogCount = 0;
            }
        }
        while (backlogCount > 0) {
            ++result;
            backlogCount -= numPerDay;
        }
        return result;
    }
}
