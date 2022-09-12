package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Brackets1Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String S = "{[()()]}";
        int result = 1;
        assertEquals(result, Brackets1.solution(S));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String S = "((((())";
        int result = 0;
        assertEquals(result, Brackets1.solution(S));
    }
}
