package com.example.soulmate.traning;

import java.util.Arrays;

public class ShuffleString {

    //Given a string s and an integer array indices of the same length.
    //
    //The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
    //
    //Return the shuffled string.


    // lleoH // 2 3 1 4 0

    public String restoreString(String s, int[] indices) {


        char[] array = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            array[indices[i]] = s.charAt(i);
        }
        System.out.println(Arrays.toString(array));

        return new String(array);

//        StringBuilder sb = new StringBuilder(s);
//        for(int i = 0; i < s.length(); i++){
//            sb.setCharAt(indices[i], s.charAt(i));
//        }
//        return sb.toString();

    }

    public static void main(String[] args) {
        ShuffleString shuffleString = new ShuffleString();
        int arr[] = {2, 3, 1, 4, 0};
        String s = "lleoH";
        shuffleString.restoreString(s, arr);
    }
}
