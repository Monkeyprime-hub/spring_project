package com.example.soulmate.traning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

    public String reverseString(String string) {
//        long count = string.chars().count();
        char[] chars = string.toCharArray();
//        Queue queue = new ArrayDeque();
//        for (int i = 0; i < chars.length; i++) {
//            queue.add(chars[i]);
//        }
//
//        for (int i = queue.size() - 1; i >= 0; i--) {
//            System.out.println(chars[i]);
//        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            list.add(chars[i]);
        }

        System.out.println(list);

//        System.out.println(count);
//        System.out.println(chars);
//        System.out.println(queue.toString());
        return string;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString("Hello");
    }

}
