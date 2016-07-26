package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        decryptionExercise();
    }

    // demonstrate decryption
    public static void decryptionExercise() {
        String message = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
        String key = "BHISOECRTMGWYVALUZDNFJKPQX";

        System.out.println("CIPHERTEXT: " + message);
        System.out.println("PLAINTEXT: " + decryptMessage(message, key));
    }

    // take ciphertext and key and return plaintext
    private static String decryptMessage(String message, String key) {
        return decryptNumbers(getNumsFromMessage(message), key);
    }

    // convert ciphertext into series of numbers ( -1 for spaces )
    private static List<Integer> getNumsFromMessage(String message) {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < message.length(); ++i)
            results.add(
                    message.charAt(i) == ' '
                            ? -1
                            : Integer.parseInt(message.substring(i++, i+1)));
        return results;
    }

    // perform decryption and return plaintext
    private static String decryptNumbers(List<Integer> nums, String key) {
        String result = "";
        for (int n : nums)
            result +=
                    (n < 0)
                            ? ' '
                            : (char)(key.indexOf(n + (int)'A') + (int)'A');
        return result;
    }
}