package com.example.soulmate.traning;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CentralLinkedListTest {

    @Test
    public void centrelLinkedListTest() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(33);
        list.add(4);
        list.add(5);
        list.add(11);
        list.add(21);
        list.add(31);
//        list.add(45);

        CentralLinkedList centralLinkedList = new CentralLinkedList();
        centralLinkedList.findCentral(list);
    }

}