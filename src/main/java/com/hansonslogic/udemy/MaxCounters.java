package com.hansonslogic.udemy;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 *
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the values of the counters after each consecutive operation will be:
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int N, int[] A); }
 *
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers
 * representing the values of the counters.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
public class MaxCounters {

    /**
     * If instruction greater than size its a MAX counter
     * @param N - size of our counters
     * @param A - array of instructions
     * @return - integer array that contains the results after following the instructions
     *
     * My initial solution:
     * Need array to return
     * Need a maxCounter to track the largest counter
     * Need loop to process the instructions
     *
     * Hint 1: Is to not set each spot to maxCounter but instead to move the start line
     * So if max is 2 then the start becomes 2
     * At some point still need to get 0 to 2 if never touched tho...
     *
     * Hint 2: Is to preform the final step of incrementing anything less than
     * Starting point to the starting point
     */
    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        Arrays.fill(counters, 0);
        int startLine = 0;
        int currentMax = 0;
        for(int i : A) {
            int x = i - 1; // our array starts a zero the input starts at 1
            if (i > N) {
                // move the start line
                startLine = currentMax;

            } else if (counters[x] < startLine) {
                // behind so needs to catch up
                counters[x] = startLine + 1;

            } else {
                // ahead plus one
                counters[x] += 1;
            }
            // check current max
            if (i <= N && counters[x] > currentMax) {
                currentMax = counters[x];
            }
        }
        // do the final hint
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < startLine) {
                counters[i] = startLine;
            }
        }
        return counters;
    }
}
