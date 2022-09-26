package com.hansonslogic.udemy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    @Test
    @DisplayName("Optimal Solution")
    void test1() {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        int result = 356;
        assertEquals(result, MaxProfit.solution(A));
    }

    // TODO: add tests for the other solutions
    // try to find a larger data set to see if we can use a timer
    // to show the performance difference
    // We could also just put them into codility and use their analysis

}
