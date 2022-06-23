package com.hansonslogic.CtheCInterview.BigO;

import com.hansonslogic.CtheCInterview.bigO.BigO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("Two to the N or 2^N")
    void run3() {
        System.out.println(BigO.twoN(10));
        assertEquals(512, BigO.twoN(10));
    }

    @Test
    @DisplayName("Sum the array then product of the array")
    void run4() {
        BigO.sumArrayThenProductOfArray(new int[]{3, 8, 9, 7, 6});
    }

    @Test
    @DisplayName("Is Prime?")
    void run5() {
       System.out.println(BigO.isPrime1(1939398789));
       System.out.println(BigO.isPrime2(7919));
    }

    @Test
    @DisplayName("All permutations of a string")
    void run6() {
        BigO.printPermutations("Josh", "--> ");
    }

    @Test
    @DisplayName("Fibonacci Recursion")
    void run7() {
        System.out.println(BigO.fibonacciRecursion(10));
    }

    @Test
    @DisplayName("Fibonacci Recursion with Memoization")
    void run8() {
        int[] memo = new int[10 + 1];
        System.out.println(BigO.fibonacciRecursionWithMemoization(10, memo));
    }
}
