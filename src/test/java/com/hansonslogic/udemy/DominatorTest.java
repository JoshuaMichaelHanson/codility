package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominatorTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int[] A = {3, 0, 1, 1, 4, 1, 1};
        int result = 6;
        assertEquals(result, Dominator.solution(A));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int result = -1;
        assertEquals(result, Dominator.solution(A));
    }
}
