package com.hansonslogic;

/**
 * This class is used to find a missing element from an Integer Array
 * Codify
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * Also see course where the SECOND algorithm comes from
 * https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/21222046#overview
 * The second hint really gives it away and would not have gotten it (performance wise) without it
 */
public class PermMissingElem {
    private PermMissingElem() {
    }

    static int solution(int[] A) {
        long actualResult = 0;
        long biggestNumber = A.length + 1;
        long expectedResults = 0;

        for (int j : A) {
            actualResult += j;
        }
        // now find expected results using the Gauss
        // n(n+1)/2
        expectedResults = (biggestNumber * (biggestNumber + 1))/2;
        // convert it back to an int
        return (int) (expectedResults - actualResult);
    }
}
