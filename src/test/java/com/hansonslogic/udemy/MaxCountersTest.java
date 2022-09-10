package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxCountersTest {
    @Test
    @DisplayName("Example Test")
    void example1() {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] result = {3, 2, 2, 4, 2};
        int N = 5;
        assertArrayEquals(result, MaxCounters.solution(N, A));
    }
}
