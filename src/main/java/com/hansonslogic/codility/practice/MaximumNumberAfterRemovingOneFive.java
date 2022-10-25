package com.hansonslogic.codility.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RoomsInSanatorium
 *
 * Write a function solution that, given an integer N, returns the maximum
 * possible values obtainable by deleting one '5' digit from the decimal
 * representation of N.  It is guaranteed that N will contain at least one '5' digit.
 *
 * Examples
 *
 * Given N = 15958, then the function should return 1958
 *
 * Given -5859 return -589
 *
 * Given -5000 return 0 -> the only other numbers left are zeros so 0
 *
 * Assume that:
 *
 * N is an integer within the range of [-999,995 .... 999,995]
 * N contains at least one '5' digit in its decimal representation
 * N consists of at least two digits in its representation
 *
 * Only correctness counts, performance will not be the focus of this assessment
 *
 */
public class MaximumNumberAfterRemovingOneFive {

    public int solution(int A) {
        // need to track if number is negative
        boolean isNegative = false;
        if (A < 0) {
            isNegative = true;
            A = Math.abs(A);
        }
        // convert A to an Integer List
        List<Integer> intList = Arrays.stream(String.valueOf(A).split("")).map(Integer::parseInt).collect(Collectors.toList());
        // convert A to Integer List
        // List<Integer> intList = Arrays.stream(A).boxed().collect(Collectors.toList());
        // find all indexes of 5
        List<Integer> fiveIndexes = intList.stream().filter(i -> i == 5)
                .collect(Collectors.toList());
        // loop through fiveIndexes removing each one and checking the number
        int highestNumber = 0;
        for (Integer fiveIndex : fiveIndexes) {
            intList.remove(fiveIndex);
            int number = Integer.parseInt(intList.stream().
                    map(String::valueOf).collect(Collectors.joining()));
            if (number > highestNumber) {
                highestNumber = number;
            }
        }

        if (isNegative) {
            highestNumber = highestNumber * -1;
        }
        return highestNumber;
    }

    public static void main(String[] args) {
        MaximumNumberAfterRemovingOneFive m = new MaximumNumberAfterRemovingOneFive();
        System.out.println(m.solution(15958)); // 1958
        System.out.println(m.solution(-5859)); // -589
        System.out.println(m.solution(-5000)); // 0
    }
}
