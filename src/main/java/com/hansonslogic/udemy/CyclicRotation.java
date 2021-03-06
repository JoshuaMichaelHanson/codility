package com.hansonslogic.udemy;

public class CyclicRotation {
    // we need to use the remainder trick
    // can get remainder by using the modulus operator
    static int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }
}
