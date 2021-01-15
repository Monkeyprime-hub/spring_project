package com.example.soulmate.traning;

import java.util.*;
import java.util.stream.Collectors;

public class SameDigits {


    Set<Integer> resultSet = new HashSet<>();

    public Set<Integer> findSameDigits(List<Integer> list) {
        Set<Integer> result = list.stream()
                .filter(integer -> !resultSet.add(integer)) //Set.add() returns false if the item was already in the set.
                .collect(Collectors.toSet());

        Set<Integer> collect = list.stream()
                .collect(Collectors.toSet());

        System.out.println(result);
        System.out.println(collect);
        return result;
    }

    public Set<Integer> findSameDigits2(List<Integer> numbers) {
        Set<Integer> integerSet = numbers.stream()
                .filter(integer -> numbers.indexOf(integer) != numbers.lastIndexOf(integer))
                .collect(Collectors.toSet());
//                .forEach(System.out::println);
        System.out.println(integerSet);
        return integerSet;
    }

    public Integer findSameDigits3(List<Integer> numbers) {
        int sum = 15;
        Integer resultInt = numbers.stream()
                .reduce((integer, integer2) -> integer + integer2) // Integer::sum
                .map(integer ->   integer - sum).get();
        System.out.println(resultInt);
        return resultInt;
    }

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);

        SameDigits sameDigits = new SameDigits();
        sameDigits.findSameDigits3(list);
    }
}
