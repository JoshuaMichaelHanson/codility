package com.hansonslogic.udemy;

public class PassingCars {

    /**
     * For mine still going to use the prefix sum approach or suffix sum approach
     * @param A array of 0s and 1s
     * @return number of passing cars
     */
    public int bradsSolution(int[] A) {
        int east = 0;
        int pairs = 0;
        for (int car : A) {
            if (car == 0) {
                // Traveling east
                ++east;
            } else {
                // Traveling west
                pairs += east;
                if (pairs > 1_000_000_000) {
                    pairs = -1;
                    break;
                }
            }
        }
        return pairs;
    }

}
