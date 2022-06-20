package com.hansonslogic.udemy;

public class TapeEquilibrium {

    /**
     *
     * @param A array of integers -1000 -- 1000
     * Always has a size of 2?
     * @return the min different of when the 2 sides of the array are almost or are equal
     */
    static int solution(int[] A) {
        // start at position 1 and calculate both sides
        // subtract until the the 2 sides are equal OR the number changes directions and go 1 back
        long leftSide = A[0];
        // find right side
        long rightSide = 0;
        for(int i = 1; i < A.length; i++) {
            rightSide += A[i];
        }
        // System.out.println("Left Side " + leftSide + " Right Side " + rightSide);
        // they could already be equal, probably not but what the heck
        long equalibrium = Math.abs(leftSide - rightSide);
        // need to do length - 1 because else there would be no right side
        // missed this on first attempt 6-11-2022 got 61% on test
        // was that the only error?
        for(int i = 1; i < A.length - 1; i++) {
            leftSide += A[i];
            rightSide -= A[i];
            long currentEqualibrium = Math.abs(leftSide - rightSide);
            // System.out.println("Left Side " + leftSide + " Right Side " + rightSide + " Equallibrium " + equalibrium);
            if (equalibrium > currentEqualibrium) {
                // had a break here but must be cases when once it starts going up can go lower again?
                equalibrium = currentEqualibrium;
            }
        }
        return (int) equalibrium;
    }
}
