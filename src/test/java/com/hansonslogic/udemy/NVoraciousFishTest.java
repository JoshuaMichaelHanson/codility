package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NVoraciousFishTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        int result = 2;
        assertEquals(result, NVoraciousFish.solution(A, B));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 0, 0, 0, 0};
        int result = 5;
        assertEquals(result, NVoraciousFish.solution(A, B));
    }
}
