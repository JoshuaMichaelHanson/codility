package com.hansonslogic.codility.practice;

import java.util.Arrays;

/**
 * This is the generic test given by Codility
 * Still a fun warm-up
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive
 * integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 *
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestIntThatDoesNotOccurInArray {

    public int solution(int[] A) {
        // remove duplicates using stream
        int[] uniqueArray = Arrays.stream(A).distinct().toArray();
        // sort the array
        Arrays.sort(uniqueArray);
        // find the smallest number and start iterating from there
        int currentInt = uniqueArray[0];
        for(int i : uniqueArray) {
            if(i == currentInt) {
                currentInt++;
            } else {
                break;
            }
        }
        return currentInt;
    }

    /**
     *
     * @param args - none
     *
     */
    public static void main(String[] args) {
        SmallestIntThatDoesNotOccurInArray s = new SmallestIntThatDoesNotOccurInArray();
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(s.solution(A));
        int[] B = {-1, -1, -2, 2, 3};
        System.out.println(s.solution(B));
    }
}
