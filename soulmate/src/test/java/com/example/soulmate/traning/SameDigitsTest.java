package com.example.soulmate.traning;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SameDigitsTest {

    @Test
    public void findSameDigitsTest() {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);

        SameDigits sameDigits = new SameDigits();
        sameDigits.findSameDigits(list);

    }

    @Test
    public void findSameDigitsTest2() {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);

        SameDigits sameDigits = new SameDigits();
        sameDigits.findSameDigits2(list);

    }

}