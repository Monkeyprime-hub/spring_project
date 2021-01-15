package com.example.soulmate.traning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallerNumbers {

    //Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
    //
    // That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    //
    //Return the answer in an array.

    public int[] smallerNumbersThanCurrent(int[] nums) {

//        int[] result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    result[i]++;
////                    count++;
//                }
//
//            }
//            System.out.println(Arrays.toString(result));
//
//        }
//        return result;

        int[] result = new int[nums.length];

        IntStream.range(0, nums.length)
                .forEach(i -> Arrays.stream(nums)
                        .filter(num -> nums[i] > num)
                        .forEach(num -> result[i]++));
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        SmallerNumbers smallerNumbers = new SmallerNumbers();
        smallerNumbers.smallerNumbersThanCurrent(arr);
    }
}
