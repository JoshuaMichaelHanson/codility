package com.hansonslogic.CtheCInterview.BigO;

import com.hansonslogic.CtheCInterview.bigO.BigO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigOTest {

    @Test
    @DisplayName("Add the runtimes")
    void run1() {
        int[] A = {3, 8, 9, 7, 6};
        int[] B = {4, 5, 6, 7, 8};
        BigO.addTheRunTimes(A, B);
    }

    @Test
    @DisplayName("Multiply the runtimes")
    void run2() {
        int[] A = {3, 8, 9, 7, 6};
        int[] B = {4, 5, 6, 7, 8};
        BigO.multiplyRunTimes(A, B);
    }


}
