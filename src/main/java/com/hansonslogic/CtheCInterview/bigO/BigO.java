package com.hansonslogic.CtheCInterview.bigO;

import org.jetbrains.annotations.NotNull;

public class BigO {

    /**
     * @param A
     * @param B
     * This would be O(A + B)
     */
    public static void addTheRunTimes(int[] A, int[] B) {
        for(int a: A) {
            System.out.println(a);
        }

        for(int b: B) {
            System.out.println(b);
        }
    }

    /**
     * @param A array of ints
     * @param B array of ints
     * This would be O(A * B)
     */
    public static void multiplyRunTimes(int[] A, int[] B) {
         for(int a: A) {
             for(int b: B) {
                 System.out.println(a + "," + b);
             }
         }
    }

    // O(log N) runtimes would be halving the results each time
    // Binary Search
    // {1, 5, 8, 9, 11, 13, 15, 19, 21}
    // Compare 9 to 11 smaller
    // {1, 5, 8, 9}
    // compare to 8 bigger
    // compare to 9 done

    /**
     * @param N number to add
     * @return the number after its added
     * This would be O(2^N)
     * Two calls for each N so two to the depth (N)
     */
    public static int twoN(int N) {
        if(N <= 1) {
            return 1;
        } else {
            return twoN(N - 1) + twoN(N - 1);
        }
    }

    /**
     * This one is O(N) the fact that we iterate through the array twice does not matter
     */
    public static void sumArrayThenProductOfArray(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        int product = 1;
        for (int a : A) {
            product *= a;
        }
        System.out.println(sum + " " + product);
    }

    // always remember to drop the constant even if that constant is 1,000,000,000 it's still a constant

    // also remember if we are doing n^2/2 it's still n^2

    // O(N + P) where P < n/2 then still O(N)
    // O(2N) is still O(N)
    // (N + log N) is still O(N)
    // O(N + M) is  NOT O(N) because M is not constant

    // sorting a string take O(s log s), because of the way sorting works
    // now do that for an array (a) of strings = O(a * s log s)
    // now sort the array of strings = O(a * s log a)
    // add them together and get
    // O(a * s (log a + log s)) = sort an array of strings and then sort the array

    /**
     *
     * @param node the node to add
     * @return the total of all nodes values
     * This is O(N) because it only touches the node value once
     */
    public static int sumNodes(Node node) {
        if(node == null) {
            return 0;
        }
        return node.value + sumNodes(node.left) + sumNodes(node.right);
    }

    // lets look at two ways to calculate a prime number the second shows why its O(Square Root of N)
    // the first is just to confuse the reader and will be the one you see on the test....
    public static boolean isPrime1(int N) {
        for(int x = 2; x * x <= N; x++) {
            if(N % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int N) {
        for(int x = 2; x <= Math.sqrt(N); x++) {
            if(N % x == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print all permutations of a string
     * Ends up being O(N * N * N!) = O((N + 2)!)
     */
    public static void printPermutations(@NotNull String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                printPermutations(rem, prefix + str.charAt(i));
            }
        }
    }

    /**
     *
     * @param n the number to find the factorial of
     * @return the factorial of n
     * This is O(N)
     */
    public static int factorial1(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial1(n - 1);
        }
    }

    /**
     *
     * @param n the nth fibonacci number
     * @return the nth fibonacci number
     * This is O(2^N) = 2 to the depth of N = 2 calls for each N
     */
    public static int fibonacciRecursion(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    /**
     * @param n the nth fibonacci
     * @param memo array to hold the results
     * @return the nth fibonacci
     * This one can run in O(N) because we are storing previous values in the memo
     */
    public static int fibonacciRecursionWithMemoization(int n, int[] memo) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(memo[n] > 0) {
            return memo[n];
        } else {
            memo[n] = fibonacciRecursionWithMemoization(n - 1, memo) + fibonacciRecursionWithMemoization(n - 2, memo);
            return memo[n];
        }
    }
}

/**
 * Don't need setters and getter for practice code LOL, hahahhahha
 */
class Node {
    public int value = 0;
    public Node left = null;
    public Node right  = null;
}


