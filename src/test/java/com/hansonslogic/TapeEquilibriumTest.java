package com.hansonslogic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibriumTest {

    @Test
    @DisplayName("Easy Test")
    void solution1() {
        int[] A = {6, 1, 2, 3};
        assertEquals(0, TapeEquilibrium.solution(A));
    }

    /**
     * A[0] = 3
     * A[1] = 1
     * A[2] = 2
     * A[3] = 4
     * A[4] = 3
     */
    @Test
    @DisplayName("Example From Online")
    void solution2() {
        int[] A = {3, 1, 2, 4, 3};
        assertEquals(1, TapeEquilibrium.solution(A));
    }
}
