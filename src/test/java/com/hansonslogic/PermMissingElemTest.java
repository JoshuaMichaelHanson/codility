package com.hansonslogic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PermMissingElemTest {

    @Test
    @DisplayName("Find Missing Numbers")
    void findMissingElement() {
        //test with at least 2 arrays for good luck
        int[] missingNumber4 = {1, 2, 3};
        int[] missingNumber35 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
        int[] missingNumber45 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 46, 47, 48, 49, 50};
        assertAll(() -> assertEquals(4, PermMissingElem.solution(missingNumber4)),
                () -> assertEquals(35, PermMissingElem.solution(missingNumber35)),
                () -> assertEquals(45, PermMissingElem.solution(missingNumber45)));

    }

    @Test
    @DisplayName("Empty Set")
    void findEmptySet() {
        int[] empty = {};
        assertEquals(1, PermMissingElem.solution(empty));
    }

    @Test
    @DisplayName("100000 last number missing")
    void findLargeNumber() {
        int[] large = IntStream.range(1, 100000).toArray();
        assertEquals(100000, PermMissingElem.solution(large));
    }
}
