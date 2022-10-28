package com.hansonslogic.codility.practice;

import java.util.Arrays;

/**
 *You are given two arrays A and B consisting of N integers each.
 * Index K is named "fair" if the four sums
 * (A[0] + ... + A[K-1]), (A[K] + ... + A[N-1]), (B[0] + ... + B[K-1])
 * and (B[K] + ... + B[N-1]) are all equal.
 * In other words, K is the index where the two arrays, A and B, can be split (into two non-empty arrays each)
 * in such a way that the sums of the resulting arrays' elements are equal.
 *
 * For example, given arrays A = [0, 4, -1, 0, 3] and B = [0, -2, 5, 0, 3], index K = 3 is fair.
 *            0  1  2 |  3  4
 *          ----------|------
 *    A  =    0  4 -1 |  0  3
 *    B  =    0 -2  5 |  0  3
 *          ----------|------
 *                  K = 3
 *
 * Index K = 3 is fair since the sums of the four subarrays are all equal:
 *    0 + 4 + (-1) = 3
 *    0 + 3 = 3
 *    0 + (-2) + 5 = 3
 *    0 + 3 = 3
 *
 * On the other hand, index K = 2 is not fair; the sums of the subarrays are not equal:
 *    0 + 4 = 4
 *    (-1) + 0 + 3 = 2
 *    0+ (-2) = -2
 *    5 + 0 + 3 = 8
 *
 * Write a function:
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * which, given two arrays of integers A and B, returns the total number of fair indexes.
 *
 * Examples:
 *   1. Given A = [0, 4, -1, 0, 3] and B = [0, -2, 5, 0, 3], your function should return 2.
 *      The fair indexes are 3 and 4. In both cases, the sums of elements of the subarrays are equal to 3.
 *   2. Given A = [2, -2, -3, 3] and B = [0, 0, 4, -4], your function should return 1.
 *      The only fair index is 2. Index 4 is not fair as the subarrays containing indexes from
 *      K to N - 1 would be empty.
 *   3. Given A = [4, -1, 0, 3] and B = [-2, 6, 0, 4], your function should return 0.
 *      There are no fair indexes.
 *   4. Given A = [3, 2, 6] and B = [4, 1, 6], your function should return 0.
 *   5. Given A = [1, 4, 2, -2, 5], B = [7, -2, -2, 2, 5], your function should return 2.
 *      The fair indexes are 2 and 4.
 *
 * Write an efficient algorithm for the following assumptions:
 *    N is an integer within the range [2..100,000]
 *    each element of arrays A and B is an integer within the range [−1,000,000,000..1,000,000,000].
 */
public class FairIndexsInTwoNonEmptyArrays {

    public int solution(int[] A, int[] B) {
        // think they always said that the arrays are non-empty, but just in case
        if(A.length == 0 || B.length == 0 || A.length != B.length) {
            return 0;
        }

        int arrayLength = A.length;
        int[] prefixSumA = new int[arrayLength];
        int[] prefixSumB = new int[arrayLength];
        int[] suffixSumA = new int[arrayLength];
        int[] suffixSumB = new int[arrayLength];

        // do the base case first to simplify the loop
        prefixSumA[0] = A[0];
        prefixSumB[0] = B[0];
        suffixSumA[arrayLength-1] = A[arrayLength-1];
        suffixSumB[arrayLength-1] = B[arrayLength-1];

        for (int i = 1; i < arrayLength; i++) {
            prefixSumA[i] = prefixSumA[i-1] + A[i];
            prefixSumB[i] = prefixSumB[i-1] + B[i];
            suffixSumA[arrayLength-1-i] = suffixSumA[arrayLength-i] + A[arrayLength-1-i];
            suffixSumB[arrayLength-1-i] = suffixSumB[arrayLength-i] + B[arrayLength-1-i];
        }

        // Arrays.stream(prefixSumA).forEach(System.out::println);
        // Arrays.stream(prefixSumB).forEach(System.out::println);
        // Arrays.stream(suffixSumA).forEach(System.out::println);
        // Arrays.stream(suffixSumB).forEach(System.out::println);
        System.out.println("prefixSumA = " + Arrays.toString(prefixSumA));
        System.out.println("prefixSumB = " + Arrays.toString(prefixSumB));
        System.out.println("suffixSumA = " + Arrays.toString(suffixSumA));
        System.out.println("suffixSumB = " + Arrays.toString(suffixSumB));

        int fairIndexes = 0;
        /**
         * Do not check the last of the prefix's and don't check the first of the suffix's
         * They are the amount of the entire array and are not fair indexes because one side is empty array
         */
        for (int i = 0; i < arrayLength-1; i++) {
            if (prefixSumA[i] == prefixSumB[i] && suffixSumA[i+1] == suffixSumB[i+1] && prefixSumA[i] == suffixSumA[i+1]) {
                System.out.println("fair index = " + i);
                System.out.println("prefixSumA[i] = " + prefixSumA[i]);
                System.out.println("prefixSumB[i] = " + prefixSumB[i]);
                System.out.println("suffixSumA[i+1] = " + suffixSumA[i+1]);
                System.out.println("suffixSumB[i+1] = " + suffixSumB[i+1]);
                fairIndexes++;
            }
        }

        return fairIndexes;
    }

    public static void main(String[] args) {
        FairIndexsInTwoNonEmptyArrays fairIndexsInTwoNonEmptyArrays = new FairIndexsInTwoNonEmptyArrays();
        int[] A = {0, 4, -1, 0, 3};
        int[] B = {0, -2, 5, 0, 3};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{2, -2, -3, 3};
        B = new int[]{0, 0, 4, -4};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{4, -1, 0, 3};
        B = new int[]{-2, 6, 0, 4};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{3, 2, 6};
        B = new int[]{4, 1, 6};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{1, 4, 2, -2, 5};
        B = new int[]{7, -2, -2, 2, 5};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{};
        B = new int[]{};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));
        A = new int[]{1};
        B = new int[]{2, 3};
        System.out.println(fairIndexsInTwoNonEmptyArrays.solution(A, B));

    }

    public int bradsSolution(int[] A, int[] B) {
        long aSum = 0;
        long bSum = 0;
        for (int i = 0; i < A.length; ++i) {
            aSum += A[i];
            bSum += B[i];
        }

        int result = 0;
        long aLeft = 0;
        long bLeft = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            aLeft += A[i];
            bLeft += B[i];
            if ((aLeft == bLeft) && (aLeft == aSum - aLeft) && (bLeft == bSum - bLeft)) {
                ++result;
            }
        }

        return result;
    }
}
