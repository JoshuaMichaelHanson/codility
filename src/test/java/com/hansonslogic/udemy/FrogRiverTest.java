package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogRiverTest {

    @Test
    @DisplayName("Test 1")
    void test1() {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int result = 6;
        assertEquals(result, FrogRiver.solution(5, A));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        int[] A = {1, 1, 1};
        int result = 0;
        assertEquals(result, FrogRiver.solution(1, A));
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        int[] A = {1, 2, 1};
        int result = -1;
        assertEquals(result, FrogRiver.solution(3, A));
    }
}
