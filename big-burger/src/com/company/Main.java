package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(maxWait(new int[] { 4,5,6,9,20 }, new int[] { 1,1,3,20,20 }));
    }

    public static int maxWait(int[] arrival, int[] server) {
        int result = -1;
        int lastServedTime = 0;
        for (int i = 0; i < arrival.length; ++i) {
            int previousServedTime = lastServedTime;
            int newOrderTime = Math.max(previousServedTime, arrival[i]);
            lastServedTime = newOrderTime + server[i];
            int waitTime = newOrderTime - arrival[i];
            if (result < waitTime)
                result = waitTime;
        }
        return result;
    }
}