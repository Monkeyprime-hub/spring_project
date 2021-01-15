package com.example.soulmate.traning;

import java.util.*;
import java.util.stream.Collectors;

public class CentralLinkedList {

    private int count = 0;
    private List<Integer> listFirst = new ArrayList<>();

    public List<Integer> findCentral(List<Integer> list) {


        for (int i = 0; i < list.size(); i++) {
            count++;
            if (count == list.size() && count % 2 == 1) {
                count = count / 2;
                Integer integer = list.stream().skip(count).findFirst().get();
                listFirst.add(integer);
                System.out.println(count);
                System.out.println(integer);

                return listFirst;

            } else if (count == list.size()) {
                count = count / 2;
//                Optional<Integer> first = list.stream().filter(integer -> list.indexOf(integer) == count && list.indexOf(integer) == count - 1).findFirst();
                list.stream().filter(integer -> list.indexOf(integer) == count || list.indexOf(integer) == count - 1).forEach(integer -> listFirst.add(integer));

                System.out.println(count);
                System.out.println(listFirst);
                return listFirst;
            }
        }

//        Object collect = list.stream().skip(count).findFirst().get();
//        System.out.println(collect);
//        return
        return list;
    }
}

// - 1