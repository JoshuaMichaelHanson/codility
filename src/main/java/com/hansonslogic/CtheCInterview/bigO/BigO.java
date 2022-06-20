package com.hansonslogic.CtheCInterview.bigO;

public class BigO {

    /**
     * @param A
     * @param B
     * This would be O(A + B)
     */
    public static void addTheRunTimes(int[] A, int[] B) {
        for(int a: A) {
            System.out.println(a);
        }

        for(int b: B) {
            System.out.println(b);
        }
    }

    /**
     * @param A array of ints
     * @param B array of ints
     * This would be O(A * B)
     */
    public static void multiplyRunTimes(int[] A, int[] B) {
         for(int a: A) {
             for(int b: B) {
                 System.out.println(a + "," + b);
             }
         }
    }

    // O(log N) runtimes would be halving the results each time
    // Binary Search
    // {1, 5, 8, 9, 11, 13, 15, 19, 21}
    // Compare 9 to 11 smaller
    // {1, 5, 8, 9}
    // compare to 8 bigger
    // compare to 9 done

    /**
     * @param N number to add
     * @return the number after its added
     * This would be O(2^N)
     * Two calls for each N
     */
    public static int twoN(int N) {
        if(N <= 1) {
            return 1;
        } else {
            return twoN(N - 1) + twoN(N - 1);
        }
    }

}


