package com.hansonslogic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {
    @Test
    @DisplayName("Move 1")
    void move1() {
        int[] A = {3, 8, 9, 7, 6};
        int[] result = {6, 3, 8, 9, 7};
        int K = 1;
        assertArrayEquals(result, CyclicRotation.solution(A, K));
    }

    @Test
    @DisplayName("Move 3")
    void move3() {
        int[] A = {3, 8, 9, 7, 6};
        int[] result = {9, 7, 6, 3, 8};
        int K = 3;
        assertArrayEquals(result, CyclicRotation.solution(A, K));
    }

}
