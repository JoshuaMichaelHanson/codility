package com.hansonslogic.udemy;

/**
 * Counting element
 * Histograms or frequency tables
 * Which element is first repeated, counting elements in a list
 * Use a data structure, hashtable O(n), array (better for things that fit in memory)
 *
 * Input is too large 0 - 2^10 = 16 gig
 * Key value or binary tree
 *
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river
 * (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the
 * river.
 *
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where
 * one leaf falls at time K, measured in seconds.
 *
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only
 * when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when
 * all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is
 * negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 *
 * For example, you are given integer X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the
 * river.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int[] A); }
 *
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can
 * jump to the other side of the river.
 *
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 *
 * For example, given X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * the function should return 6, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 */
public class FrogRiver {

    /**
     *
     * @param X - width of the river
     * @param A - list of where and when the leaves will fall
     *          each space is 1 second (or whatever time measurement)
     * @return - the earliest time the frog can cross the river or -1 if it can never cross
     *
     * My initial solution: We could use another array to check for each position if its not taken subtract one from counter
     * if its taken do not subtract one from counter.  When counter is 0 return position else -1
     *
     * Real Solution says to:  They do the same but use a boolean array with X + 1 since its 1 - X
     *
     */
    static int solution(int X, int[] A) {
        // boolean initializes to false
        // Boolean initializes to null
        boolean[] riverPosition = new boolean[X + 1];
        for(int time = 0; time < A.length; time++) {
            int pos = A[time];
            if(!riverPosition[pos]) {
                riverPosition[pos] = true;
                X -= 1; // reuse the input length
                if(X == 0) {
                    return time;
                }
            }
        }
        return -1;
    }
}
