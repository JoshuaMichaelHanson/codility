package com.hansonslogic.udemy;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Dominator {

    /**
     *
     * @param A - input array
     * @return - the leader
     *
     * Hint 1: Remove elements that are next to each other that are not the same
     * Hint 2:  Use a stack, if empty insert
     *          Else pop and compare if different throw away
     *          If same push both
     *          Which ever element is left on array
     *          Take and count, then pass back index
     *          Good for runtime, bad for memory
     *
     *          Get rid of the stack and use a
     *          variable since the stack is only
     *          storing the same element
     *
     *          NEED: candidate and counter
     *          If different number replace and counter to zero
     *          Could keep totalCount and index but might not make it faster
     *
     *
     *
     *
     */
    public static int solution(int[] A) {
        int totalCount = 0;
        int candidate = 0;
        int index = -1;
        int candidateCount = 0;

        for (int i : A) {
            if (totalCount == 0) {
                candidate = i;
                totalCount++;
            } else if (candidate == i) {
                totalCount++;
            } else {
                totalCount--;
            }
        }
        // now find out how many are in the array
        for(int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                candidateCount++;
                index = i;
            }
        }
        if (candidateCount > (A.length / 2.0)) {
            return index;
        }
        return -1;
        // return candidateCount > A.length / 2.0 ? index : -1;
    }
}
